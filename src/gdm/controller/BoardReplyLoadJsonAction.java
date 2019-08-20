package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReplyLoadJsonAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("댓글 조회하기");
		
//		글번호
//		회원번호
//		글쓴이
//		비밀번호
//		댓글내용
//		
		return null;
	}

}
