package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

//URI : /loin
//service함수를 를 이용해서 login 처리하세요
//유효성 검증 실패시 /WEB-INF/error.jsp 로 포워딩 (에러메시지도 같이보여주면 좋고..아니어도 패스)
//회원가입 성공시 Main.jsp 로 리다이렉트 

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("Servlet /login..");
		String method = req.getMethod();
		if(method.contains("GET")) {
			System.out.println("GET /login..");
			req.getRequestDispatcher("/WEB-INF/View/login.jsp").forward(req, resp);
			return;
		}
		
		//1
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//2
		if(!isValid(username,password)) {
			return;
		}
		
		//3 서비스실행(비즈니스 로직..)
//		if(!username.equals("user1")) {
//			return;
//		}
//		if(!password.equals("1234")) {
//			return;
//		}
		HttpSession session = req.getSession();
		//세션에 권한정보 넣기
		session.setAttribute("username", username);
		session.setAttribute("role", Role.ROLE_USER);
		
		//4 뷰로 이동
		resp.sendRedirect(req.getContextPath() + "/main");
		
	}

	private boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
