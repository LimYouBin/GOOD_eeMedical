package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdm.dao.BoardDAO;
import gdm.dto.BoardVO;

public class BoardListAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("index.jsp에서 게시판 이동 시 Action단");
		
		int pageno = 0; // 페이지 번호
		int listCnt = 0; // 한 페이지당 보여줄 게시글 수
		
		if(request.getParameter("page") != null)
			pageno = Integer.parseInt(request.getParameter("page")); // 넘어온 페이지 번호
		else { // 페이지번호가 넘어오지않으면 예외처리해주기
			
		}
		
		if(request.getParameter("listCnt") != null)
			listCnt = Integer.parseInt(request.getParameter("listCnt")); // 넘어온 게시글 수
		else { // 게시글 수 가 넘어오지않으면 예외처리해주기
			
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int totalPostCnt = dao.getTotalPostCnt(); // 전체 게시글 수
		int totalPage = 0; // 총 페이지 수
		
		if((totalPostCnt % listCnt) == 0)
			totalPage = totalPostCnt / listCnt;
		else
			totalPage = totalPostCnt / listCnt + 1;
		
		int blockPerPage = 10; // 리스트 페이지에서 한번에 보여줄 페이지 수
		int startPage = (pageno - 1) / blockPerPage * blockPerPage + 1;
		int endPage = startPage + blockPerPage - 1;
		
		if(endPage > totalPage) // endPage 보정
			endPage = totalPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCnt", listCnt);
		request.setAttribute("pageno", pageno);
				
		List<BoardVO> boardList = dao.displayBoardList(pageno, listCnt);
		
		request.setAttribute("boards", boardList); // 실제 글 목록 request 영역의 boards 속성에 저장
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // 포워딩 해야 함
		forward.setPath("./board/list.jsp"); // 포워딩 할 경로
		
		return forward;
	}

}
