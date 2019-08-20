package gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdm.dto.BoardVO;
import gdm.dto.MembersVO;
import util.DBCon;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	private BoardDAO() { }
	
	public static BoardDAO getInstance() {
		if(instance == null)
			return new BoardDAO();
		
		return instance;
	}
	
	// 로그인
	public MembersVO login(String id, String pwd) throws ClassNotFoundException, SQLException {
		MembersVO mvo = null;
		String query = "select * from members where member_name='" + id + "' and member_pwd='" + pwd + "'";
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			mvo = new MembersVO(rs.getInt("member_no"), rs.getString("member_name"), rs.getString("nickname"));
		
		rs.close();
		pstmt.close();
		con.close();
		
		return mvo;
	}

	// 게시판 출력
	public List<BoardVO> DisplayBoardList(int pageno, int listCnt) throws ClassNotFoundException, SQLException {
		int offset = (pageno - 1) * listCnt; // 페이지에 보여줄 시작 offset
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String query = "select paging.* from (select * from gdproject.board limit " + offset + ", "+listCnt + ") paging order by board_no desc";
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			boardList.add(new BoardVO(rs.getInt("board_no"), rs.getInt("member_no"), rs.getString("board_title"), rs.getDate("postdate"), rs.getString("writer"),
					rs.getInt("viewcnt"), rs.getInt("likecnt")));
		
		System.out.println(boardList);
		
		rs.close();
		pstmt.close();
		con.close();
		
		return boardList;
	}
	
	// 전체 게시글 수
	public int getTotalPostCnt() throws ClassNotFoundException, SQLException {
		int totalPostCnt = 0;
		String query = "select count(*) as total from gdproject.board";
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			totalPostCnt = rs.getInt("total");
		
		rs.close();
		pstmt.close();
		con.close();
		
		return totalPostCnt;
	}

	// 게시글 내용 조회
	public BoardVO DisplayBoardContent(int bno) throws ClassNotFoundException, SQLException {
		String query = "select * from gdproject.board where board_no=" + bno;
		BoardVO bvo = null;
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			bvo = new BoardVO(rs.getInt("board_no"), rs.getInt("member_no"), rs.getString("board_title"), rs.getString("board_pwd"),
					rs.getDate("postdate"), rs.getString("writer"), rs.getString("content"),
					rs.getString("contentimg"), rs.getInt("viewcnt"), rs.getInt("likecnt"), rs.getInt("unlikecnt"));
		
		System.out.println(bvo);
		
		rs.close();
		pstmt.close();
		con.close();
		
		return bvo;
	}

	// 글 번호 중 가장 큰 번호 + 1값 반환
	public int getMaxBoardNum() throws ClassNotFoundException, SQLException {
		int max = 1; // 글 번호 (만약 첫번째 등록되는 글이라면 rs반환값은 null. null+1=null 이므로 초기값을 1로 준다.
		String query = "select max(board_no) as max from gdproject.board";
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			max = rs.getInt("max") + 1;
		
		rs.close();
		pstmt.close();
		con.close();
		
		return max;
	}
	
	// 게시글 삭제
	public boolean BoardDelete(int no) throws ClassNotFoundException, SQLException {
		boolean result = false;
		String query = "delete from gdproject.board where board_no = " + no;
		
		System.out.println(query);
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		int i = pstmt.executeUpdate();
		
		if(i == 1)
			result = true;
		
		pstmt.close();
		con.close();
		
		return result;
	}	
}
