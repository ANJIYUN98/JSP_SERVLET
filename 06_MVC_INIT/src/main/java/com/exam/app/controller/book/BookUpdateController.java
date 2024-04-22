package com.exam.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.app.controller.SubController;

public class BookUpdateController implements SubController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookUpdateController's execute() invoke..");
		
	}

}
