package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdm.dao.BoardDAO;

public class BoardDeleteAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("게시글 삭제 Action단");
		
		boolean result = false;
		int no = Integer.parseInt(request.getParameter("no")); // 글 번호
		
		System.out.println(no);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.boardDelete(no);
		
		ActionForward forward = new ActionForward();
		
		if(result) { // 삭제가 되었으면 목록으로
			forward.setRedirect(false);
			forward.setPath("Controller.do?command=community&listCnt=10&page=1");
		}
		else { // 삭제가 되지 않았다면(DAO에서 false가 넘어온다면) alert창 띄우고 게시글로
			forward.setRedirect(false);
			forward.setPath("Controller.do?command=bdContView&no=" + no);
		}
		
		return forward;
	}

}
