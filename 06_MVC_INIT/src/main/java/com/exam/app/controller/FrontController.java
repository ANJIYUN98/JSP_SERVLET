package com.exam.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.app.controller.book.BookAddController;
import com.exam.app.controller.book.BookDeleteController;
import com.exam.app.controller.book.BookListController;
import com.exam.app.controller.book.BookReadController;
import com.exam.app.controller.book.BookUpdateController;


public class FrontController extends HttpServlet{
	
	private Map<String,SubController> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");
		
		map = new HashMap();
		
		String path = config.getServletContext().getContextPath();
		
		// '/'
		map.put(path+"/", new HomeController());
		
		//book
		map.put(path+"/book/add", new BookAddController());
		map.put(path+"/book/list", new BookListController());
		map.put(path+"/book/read", new BookReadController());
		map.put(path+"/book/update", new BookUpdateController());
		map.put(path+"/book/delete", new BookDeleteController());
		
		//user
		
		//lend
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("FrontController's service() invoke.."+uri);
		
		SubController controller = map.get(uri);
		if(controller==null) {
			throw new ServletException("해당 페이지는 존재하지 않습니다..");
		}
		controller.execute(request, response);
	}

	
	
}
