package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdm.dao.BoardDAO;
import gdm.dto.MembersVO;

public class Login implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("로그인 action");
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpwd");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		MembersVO mvo = dao.login(id, pwd);
		
		HttpSession ses = request.getSession();
		ses.setAttribute("user", mvo);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("../index.jsp");
		
		return null;
	}

}
