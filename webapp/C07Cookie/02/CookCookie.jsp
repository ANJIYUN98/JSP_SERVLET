<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	쿠키
	문자열 데이터로만 저장가능
	4kbyte 이하의 공간을 차지
	여러개의 쿠키 설정가능(최대 300개)
	도메인당 20개까지 저장 가능
	저장한도를 초과하면 최근에 사용되지 않는 쿠키부터 자동 삭제됨
	인증작업시 쿠키 사용
 -->
 
 <%
 	/* 쿠키 생성 */
 	Cookie cookie = new Cookie("c1","v1");
 	cookie.setMaxAge(60*60); //쿠키 유지 기간 | -1(기본값) : 파일생성은 되지 않으나 브라우저가 종료될때까지 쿠키정보 저장
 						  //브라우저 종료시 삭제
 	cookie.setPath("/");	//현재 도메인 내의 모든 위치로 전달
 						  
 	Cookie cookie2 = new Cookie("c2","v2");
 	cookie2.setMaxAge(60*60);
 	cookie2.setPath("./");	//현재 패키지 내의 페이지로만 전달
 	
 	Cookie cookie3 = new Cookie("c3","v3");
 	cookie3.setMaxAge(60*60);
 	cookie3.setPath("/01_JSP/C07Cookie/02/cookieTest,jsp");	//지정된 특정 URL로만 전달
 	
 	//쿠키 전달
 	response.addCookie(cookie);
 	response.addCookie(cookie2);
 	response.addCookie(cookie3);
 %>
 
 <a href="confirmCookie.jsp">쿠키확인 페이지</a>
 
</body>
</html>