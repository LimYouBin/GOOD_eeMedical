package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gdm.dao.BoardDAO;

public class BoardWriteAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("게시글 작성 Action단");
		
		String saveFileFolder = "uploads"; // 이미지가 저장 될 폴더 이름
		String upfilePath = request.getServletContext().getRealPath(saveFileFolder); // 이미지가 저장되는 폴더의 실제 경로
		System.out.println(upfilePath);
		int fileSize = 5 * 1024 * 1024; // 5MB
		
//		// MultipartRequest 객체가 생성되는 순간 파일은 자동으로 업로드가 된다.
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request, upfilePath, fileSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mr = null;
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int board_no = dao.getMaxBoardNum(); // 현재글이 insert될 때 이 글의 글 번호 얻어오기
		String bd_writer = mr.getParameter("bd_writer");
		String bd_pwd = mr.getParameter("bd_pwd");
		String bd_title = mr.getParameter("bd_title");
		String bd_cont = mr.getParameter("bd_cont");
		
//		if( != null) { //회원이 글 작성 시
//			MembersVO에 번호 이름 닉네임 저장되어있고 sessionScope에 값이 저장되있는데 이 곳으로 값을 불러오려면??
//		}
//		else { // 비회원이 글 작성 시
//			
//		}
		
//		BoardDAO bvo = new BoardDAO(board_no, bd_title, bd_pwd, bd_writer);
//		
//		dao.insertBoard();

		return null;
	}

}
