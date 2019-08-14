package gdm.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdm.dao.BoardDAO;
import gdm.dto.BoardVO;

public class BoardListAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		System.out.println("게시판 전체 목록 보기");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> boardList = dao.DisplayBoardList();
		
		request.setAttribute("boards", boardList); // 실제 글 목록 request 영역의 boards 속성에 저장
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 포워딩 해야 함
		forward.setPath("./board/list.jsp"); // 포워딩 할 경로
		
		return forward;
	}

}
