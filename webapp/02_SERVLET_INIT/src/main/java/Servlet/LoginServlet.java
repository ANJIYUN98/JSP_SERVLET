package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//URI : /loin
//service함수를 를 이용해서 login 처리하세요
//유효성 검증 실패시 /WEB-INF/error.jsp 로 포워딩 (에러메시지도 같이보여주면 좋고..아니어도 패스)
//회원가입 성공시 Main.jsp 로 리다이렉트 

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		if(method!= null && method.contains("GET")) {
			System.out.println("GET /login...");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
		if(method!= null && method.contains("POST")) {
			System.out.println("post /login...");
			
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
			if(!username.equals("USER1")) {
				req.getRequestDispatcher("error.jsp").forward(req, resp);
				return;
			}
			if(!password.equals("1234")) {
				req.getRequestDispatcher("error.jsp").forward(req, resp);
				return;
			}
			session.setAttribute("username", username);
			session.setAttribute("password", password);
					
			//4
			resp.sendRedirect("Main.jsp");
		}
		
	}

	private boolean isValid(String username, String password) {
		if(username==null)
			return false;
		if(password==null)
			return false;
		return true;
	}

	
}
