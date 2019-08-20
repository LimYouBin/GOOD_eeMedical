package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gdm.dao.BoardDAO;
import gdm.dto.BoardVO;

public class BoardListCntJsonAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		// 게시글 가져오기 with paging
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
		
		System.out.println(pageno + "페이지 " + listCnt + "개씩 게시글 보기");
		
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
		request.setAttribute("pageno", pageno);
				
		List<BoardVO> boardList = dao.DisplayBoardList(pageno, listCnt);
		
		// JSon으로 반환하기
		Gson gson = new Gson();		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i=0; i<boardList.size(); i++) {
			if(i != boardList.size()-1)
				sb.append(gson.toJson(boardList.get(i)) + ",");
			else
				sb.append(gson.toJson(boardList.get(i)));
		}
		sb.append("]");		
		System.out.println(sb);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		java.io.PrintWriter out = response.getWriter();
		out.print(sb);
		
		return null;
	}

}
