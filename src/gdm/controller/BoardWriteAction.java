package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gdm.dao.BoardDAO;
import gdm.dto.BoardVO;
import gdm.dto.MembersVO;

public class BoardWriteAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("게시글 작성 Action단");
		
		String saveFileFolder = "uploads"; // 이미지가 저장 될 폴더 이름
		String upfilePath = request.getServletContext().getRealPath(saveFileFolder); // 이미지가 저장되는 폴더의 실제 경로
		System.out.println(upfilePath);
		int fileSize = 5 * 1024 * 1024; // 5MB
		
//		MultipartRequest 객체가 생성되는 순간 파일은 자동으로 업로드가 된다.
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(request, upfilePath, fileSize, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mr = null;
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO bvo = null;
		int board_no = dao.getMaxBoardNum(); // 현재글이 insert될 때 이 글의 글 번호 얻어오기
		
		String fileName=""; // 파일이름		
		if(mr.getFilesystemName("bd_imgfile") == null) // 유저가 게시판에 이미지를 올리지않은 경우
			fileName = "";
		else // 유저가 게시판에 파일을 올린경우
			fileName = "uploads/" + mr.getFilesystemName("bd_imgfile");
		
		String bd_title = ""; // 글 제목
		String bd_pwd = ""; // 글 비밀번호
		String bd_writer = ""; // 글 작성자
		String bd_cont = ""; // 글 내용
		int member_no = 0; // 회원번호
		boolean isMember = false; // 회원이 글 쓰는지 비회원이 글 쓰는지 확인 (true : 회원 / false : 비회원)
			
		// session에서 멤버 값 얻어오기!!!!
		HttpSession hs = request.getSession();
		MembersVO vo = (MembersVO)hs.getAttribute("user");
		
		System.out.println(vo);
		
		if(vo != null) { //회원이 글 작성 시
			member_no = vo.getMember_no();
			bd_title = mr.getParameter("bd_title");
			bd_pwd = mr.getParameter("bd_pwd");
			bd_writer = mr.getParameter("bd_writer");
			bd_cont = mr.getParameter("bd_cont");
			isMember = true;
			
			bvo = new BoardVO(board_no, member_no, bd_title, bd_pwd, bd_writer, bd_cont, fileName);
		}
		else { // 비회원이 글 작성 시
			bd_title = mr.getParameter("bd_title");
			bd_pwd = mr.getParameter("bd_pwd");
			bd_writer = mr.getParameter("bd_writer");
			bd_cont = mr.getParameter("bd_cont");
			isMember = false;
			
			bvo = new BoardVO(board_no, bd_title, bd_pwd, bd_writer, bd_cont, fileName);
		}
		
		dao.insertBoard(bvo, isMember);

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("Controller.do?command=bdContView&no=" + board_no);
		
		return forward;
	}

}
