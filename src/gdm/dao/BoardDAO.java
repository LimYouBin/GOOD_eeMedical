package gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdm.dto.BoardVO;

import util.DBCon;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	private BoardDAO() { }
	
	public static BoardDAO getInstance() {
		if(instance == null)
			return new BoardDAO();
		
		return instance;
	}

	// 게시판 전체 출력
	public List<BoardVO> DisplayBoardList() throws ClassNotFoundException, SQLException {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String query = "select * from gdproject.board order by board_no desc";
		
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

	// 게시글 내용 조회
	public BoardVO DisplayBoardContent(int bno) throws ClassNotFoundException, SQLException {
		String query = "select * from board where board_no=" + bno;
		BoardVO bvo = null;
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			bvo = new BoardVO(rs.getInt("board_no"), rs.getInt("member_no"), rs.getString("board_title"), rs.getString("board_pwd"),
					rs.getDate("postdate"), rs.getDate("modifydate"), rs.getString("writer"), rs.getString("content"),
					rs.getString("contentimg"), rs.getInt("viewcnt"), rs.getInt("likecnt"), rs.getInt("unlikecnt"));
		
		System.out.println(bvo);
		
		rs.close();
		pstmt.close();
		con.close();
		
		return bvo;
	}
}
