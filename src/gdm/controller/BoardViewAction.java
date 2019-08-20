package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import gdm.dao.BoardDAO;
import gdm.dto.BdreplyVO;
import gdm.dto.BdreplyVOJson;
import gdm.dto.BoardVO;
import gdm.dto.MembersVO;

public class BoardViewAction implements IActionForward {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("게시글 상세 보기");
		
		int bno= Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO bvo = dao.displayBoardContent(bno); // 게시글 정보 받아오기
		request.setAttribute("board", bvo);
		
		// 댓글정보 받아와서 JSon으로 반환하기
		List<BdreplyVO> boardList= dao.displayBoardReply(bno); // 댓글 정보 받아오기
		int replyCnt = dao.getTotalReplyCnt(bno); // 총 댓글 수 받아 오기
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
		
		BdreplyVO[] replys = gson.fromJson(sb.toString(), BdreplyVO[].class); // String으로 만들어진 json 형태인 sb를 vo 배열 객체로 만든다
		String json = "";
		
		BdreplyVOJson jsonReply = new BdreplyVOJson(replyCnt, replys);
		json = gson.toJson(jsonReply);
		BdreplyVOJson finalReply = gson.fromJson(json, BdreplyVOJson.class);
		
		request.setAttribute("replys", finalReply);
		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("utf-8");
//		
//		java.io.PrintWriter out = response.getWriter();
//		out.print(sb);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/contentView.jsp");
		
		return forward;
	}

}
