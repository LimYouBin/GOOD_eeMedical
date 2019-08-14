package gdm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet({ "/ControlServlet", "/Controller.do" })
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doControl(request, response);
	}

	protected void doControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ControlServlet이 호출 됨!");
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		ActionForward forward = null; // 페이지 이동할 방법과 경로
		IActionForward action = null; // 실제 수행할 작업(DAO단 호출 등의)
		
		if(command != null) {
			if(command.equals("community")) { // 게시판 전체 리스트
				System.out.println("게시판 전체 목록 보기");
				
				action = new BoardListAction();
				
				try {
					forward = action.execute(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(command.equals("bdContView")) {
				System.out.println("게시글 상세 보기");
				
				action = new BoardViewAction();
				
				try {
					forward = action.execute(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(forward != null) {
				if(forward.isRedirect()) // redirect 해야 할 때 - forward.isRedirect 값이 참
					response.sendRedirect(forward.getPath());
				else { // 포워딩 해야 할 때 - forward.isRedirect 값이 거짓
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response); // forward 객체의 path 경로로 forward
				}
			}
			else {
				response.setContentType("text/html; charset=utf-8");
				java.io.PrintWriter out = response.getWriter();
				
				out.print("<script>");
				out.print("alert('잘못된 요청입니다!');");
				out.print("location.href='index.jsp';");
				out.print("</script>");
			}
		}
		else { // 잘못된 경로입니다라고 출력해주기
			System.out.println("널이다");
		}
	}
}
