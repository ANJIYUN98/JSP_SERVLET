package com.exam.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.app.controller.SubController;

public class BookAddController implements SubController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookAddController's execute() invoke..");
		
	}

}
