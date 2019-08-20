package gdm.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdm.dao.BoardDAO;
import gdm.dto.BoardVO;
import gdm.dto.MembersVO;

public class BoardViewAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		System.out.println("게시글 상세 보기");
		
		int bno= Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO bvo = dao.displayBoardContent(bno);
		
		request.setAttribute("board", bvo);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/contentView.jsp");
		
		return forward;
	}

}
