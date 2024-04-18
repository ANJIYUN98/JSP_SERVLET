<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		MESSAGE : ${msg}
	</div>
	
	<!-- 매핑을 위해 form 태그에 프로젝트 경로를 받아야 한다. -->
	<form action="${pageContext.request.contextPath}/login.do"> 
		<input type="text" name="username" />
		<input type="text" name="password" />
		<button>요청</button>
	</form>
	<%
		session.removeAttribute("msg");
	%>

</body>
</html>