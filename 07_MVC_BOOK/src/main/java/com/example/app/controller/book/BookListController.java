package com.example.app.controller.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.Common.ConnectionPool;
import com.example.app.domain.common.dto.BookDto;
import com.example.app.domain.common.dto.Criteria;
import com.example.app.domain.common.service.BookService;
import com.example.app.domain.common.service.BookServiceImpl;

public class BookListController  implements SubController{
	
	private BookService bookService;
	private ConnectionPool connectionPool;
	
	public BookListController() {
		
		try {
			
			bookService = BookServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookListController's execute() invoke");
		
		try {
			
			//String method = request.getMethod();
			
			//1 파라미터 받기
			//1000건 -> 한 페이지에 10건 -> 100페이지
			//PageNo
			//Amount : 10건
			//type 
			//Keyword
			
			String pageNo = request.getParameter("pageNo");
			String type = request.getParameter("type");
			String keyword = request.getParameter("keyword");
			
			Criteria criteria = null;
			if(pageNo==null) {
				
				criteria = new Criteria();	//pageno=1 amount=10
				
			}
			else {
				
				if(type==null || keyword==null || type.isEmpty() || keyword.isEmpty()) {
					criteria = new Criteria(Integer.parseInt(pageNo),10);	//pageno=1 amount=10
					
				}else {
					criteria = new Criteria(Integer.parseInt(pageNo),10,type,keyword);	//pageno=1 amount=10
				}
			}
			
			
			
			//2 유효성 체크
			
			//3 서비스 실행
			Map<String,Object> returnValue = bookService.getAllBooks(criteria);
			
			//4 뷰
			request.setAttribute("list", returnValue.get("list"));
			request.setAttribute("pageDto", returnValue.get("pageDto"));
			request.setAttribute("count", returnValue.get("count"));
			
			request.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(request, response);
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기..or new ServletException("message") 처ㅣ
		}
		
	}

}
