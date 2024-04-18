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
		//session
		session.setAttribute("ID", "USER1");
		session.setAttribute("ROLE", "ROLE_ADMIN");
		
		//request
		request.setAttribute("ID2", "USER2");
		request.setAttribute("ROLE2", "ROLE_MEMBER");
	%>
	
	<!-- a태그는 기본적으로 Get방식 -->
	<a href="GetSession.jsp">세션 정보확인</a>
	
	
</body>
</html>