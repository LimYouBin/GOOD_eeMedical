package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplySubmitJsonAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("댓글 등록하기");
		
		String rp_writer = request.getParameter("rp_writer");
		String rp_pwd = request.getParameter("rp_pwd");
		String rp_cont = request.getParameter("rp_cont");
		
		return null;
	}

}
