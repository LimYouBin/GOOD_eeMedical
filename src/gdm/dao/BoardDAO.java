package gdm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdm.dto.BdreplyVO;
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
	public List<BoardVO> displayBoardList(int pageno, int listCnt) throws ClassNotFoundException, SQLException {
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
		String query = query = "select count(*) as total from gdproject.board";
				
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
	public BoardVO displayBoardContent(int bno) throws ClassNotFoundException, SQLException {
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
	
	// 게시글 댓글 조회
	public List<BdreplyVO> displayBoardReply(int bno) throws ClassNotFoundException, SQLException {
		List<BdreplyVO> boardList = new ArrayList<BdreplyVO>();
		String query = "select * from gdproject.bdreply where board_no=" + bno;
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			boardList.add(new BdreplyVO(rs.getInt("reply_no"), rs.getInt("board_no"), rs.getInt("member_no"), rs.getString("writer"),
					rs.getString("reply_pwd"), rs.getDate("postdate"), rs.getString("content"), rs.getInt("reply_step"), rs.getInt("reply_order")));
		
		rs.close();
		pstmt.close();
		con.close();
		
		return boardList;
	}
	
	// 해당글에 대한 전체 댓글 수
	public int getTotalReplyCnt(int bno) throws ClassNotFoundException, SQLException {
		int totalReplyCnt = 0;
		String query = query = "select count(*) as total from gdproject.bdreply where board_no = " + bno;
				
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			totalReplyCnt = rs.getInt("total");
		
		rs.close();
		pstmt.close();
		con.close();
		
		return totalReplyCnt;
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
	public boolean boardDelete(int no) throws ClassNotFoundException, SQLException {
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

	// 게시글 작성
	public void insertBoard(BoardVO bvo, boolean isMember) throws ClassNotFoundException, SQLException {
		Connection con = DBCon.getConnection();
		
		if(isMember) { // 회원이 글 쓴다면
			String query = "{call pro_insertMemberBoard(?, ?, ?, ?, ?, ?, ?)}";
						
			CallableStatement cstmt = con.prepareCall(query);
			cstmt.setInt(1, bvo.getBoard_no());
			cstmt.setInt(2, bvo.getMember_no());
			cstmt.setString(3, bvo.getBoard_title());
			cstmt.setString(4, bvo.getBoard_pwd());
			cstmt.setString(5, bvo.getWriter());
			cstmt.setString(6, bvo.getContent());
			cstmt.setString(7, bvo.getContentimg());
			cstmt.execute();
			
			cstmt.close();			
		}
		else { // 비회원이 글 쓴다면
			String query = "{call pro_insertUnknownBoard(?, ?, ?, ?, ?, ?)}";
			
			CallableStatement cstmt = con.prepareCall(query);
			cstmt.setInt(1, bvo.getBoard_no());
			cstmt.setString(2, bvo.getBoard_title());
			cstmt.setString(3, bvo.getBoard_pwd());
			cstmt.setString(4, bvo.getWriter());
			cstmt.setString(5, bvo.getContent());
			cstmt.setString(6, bvo.getContentimg());
			cstmt.execute();
			
			cstmt.close();
		}
		
		con.close();		
	}
}
