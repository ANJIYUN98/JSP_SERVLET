package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//URI : /join
//doGet / doPost 를 이용해서 Join 처리하세요
//유효성 검증 실패시 /WEB-INF/error.jsp 로 포워딩
//회원가입 성공시 /login 으로 리다이렉트 
@WebServlet("/join")
public class JoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join...");
		req.getRequestDispatcher("/WEB-INF/Join1.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1 파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
				
		//2 유효성체크
		if(!isValid(username,password)) {
			req.setAttribute("msg", "Validation Check Error");
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
			return;
		}
				
		//3
		HttpSession session = req.getSession();
		if(username.length()<4) {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			return;
		}
		if(!(password.length()>=4)) {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			return;
		}
		session.setAttribute("username", username);
		session.setAttribute("password", password);
				
		//4
		resp.sendRedirect(req.getContextPath() + "/login");
	}
	
	private boolean isValid(String username, String password) {
		if(username==null)
			return false;
		if(password==null)
			return false;
		return true;
	}
	

}
