<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- servlet의 서비스 영역, 클라이언트의 요청사항을 볼 수 있음 -->
	<%
		String protocol = request.getProtocol();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String method = request.getMethod();
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String Browser = request.getHeader("User-Agent");
		String fileType = request.getHeader("Accept");
	%>
	
	<!-- 뷰로 전달 -->
	프로토콜 : <%=protocol %><br>
	서버이름 : <%=serverName %><br>
	서버포트 : <%=serverPort %><br>
	고객주소 : <%=remoteAddr %><br>
	고객이름 : <%=remoteHost %><br>
	요청함수 : <%=method %><br>
	요청경로 : <%=requestURL %><br>
	요청경로 : <%=requestURI %><br>
	브라우저 : <%=Browser %><br>
	파일타입 : <%=fileType %><br>
	
	<hr>
	
	프로토콜 : ${pageContext.request.protocol}<br>
	서버이름 : ${pageContext.request.serverName}<br>
	서버포트 : ${pageContext.request.serverPort}<br>
	고객주소 : ${pageContext.request.remoteAddr}<br>
	고객이름 : ${pageContext.request.remoteHost}<br>
	요청함수 : ${pageContext.request.method}<br>
	요청경로 : ${pageContext.request.requestURL}<br>
	요청경로 : ${pageContext.request.requestURI}<br>
	브라우저 : ${header["User-Agent"]}<br>
	파일타입 : ${header["Accept"]}<br>


</body>
</html>