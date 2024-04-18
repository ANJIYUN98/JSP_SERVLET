<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		System.out.println("PageContext : " + pageContext);
		System.out.println("PageContext : " + pageContext.getRequest());	//Request 객체 꺼내옴
		System.out.println("PageContext : " + pageContext.getResponse());	//Response 객체 꺼내옴
		System.out.println("PageContext : " + pageContext.getSession());	//Session 객체 꺼내옴
		System.out.println("PageContext : " + pageContext.getServletContext());	//ServletContext 객체 꺼내옴
		System.out.println("PageContext : " + pageContext.getServletContext().getContextPath());	//ProjectPath
	%>
	
	PROJECT PATH : ${pageContext.request.contextPath} <br>
	
</body>
</html>