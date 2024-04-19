package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Type.Role;

public class PermissionFilter implements Filter{

	// /user 	Role.ROLE_USER
	// /manager 	Role.ROLE_MANAGER
	// /admin 	Role.ROLE_ADMIN
	
	Map<String,Role> pageGradeMap = new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String path = filterConfig.getServletContext().getContextPath();
		
		pageGradeMap.put(path + "/user", Role.ROLE_USER);
		pageGradeMap.put(path + "/manager", Role.ROLE_MANAGER);
		pageGradeMap.put(path + "/admin", Role.ROLE_ADMIN);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		//전
		System.out.println("PermissionFilter start..");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Role userRole = (Role)session.getAttribute("role"); //현재 접속 USER의 Role
		if(userRole==null) {
			throw new ServletException("익명 계정으로는 접근이 불가능한 페이지입니다.");
		}
		
		//PageGradeMap에서 어떤 요청(/user,/member,/admin)이 있는지 확인해서 해당 페이지 권한을 추출
		String reqUri = req.getRequestURI();
		System.out.println("URI : " + reqUri);
		Role pageRole = pageGradeMap.get(reqUri);
		
		// 접속 계정 : ROLE_USER(0), 요청페이지 : ROLE_MANAGER(1), ROLE_ADMIN(2)
		if(userRole.ordinal() < pageRole.ordinal()) {
			throw new ServletException("해당 권한으로는 접근이 불가능합니다.");
		}
		
		
		chain.doFilter(request, response);
		System.out.println("PermissionFilter end..");
		
		
		//후
		
	}

	
}
