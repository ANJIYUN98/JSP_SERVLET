<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="num" value="123" />
	
	<!-- 변수 출력(확인) -->
	<c:out value="${num}" />
	NUM : ${num} <br>
	<hr>
	
	<!-- 배열 지정 -->
	<c:set var="arr" value="${[10,20,30,40,50]}" /> 
	<c:out value="${arr}" /> <br>
	<c:out value="${arr[1]}" /> <br>
	
	<!-- if문 -->
	<%-- <c:set var="flag" vlaue="true" /> <br> --%>
	<c:if test="${empty flag}">
		<c:out value="flag false!!" />
	</c:if>
	<c:if test="${not empty flag}">
		<c:out value="flag true!!" />
	</c:if>
	
	<hr>
	<!-- choose when (IF else 문과 비슷) -->
	<c:set var="str" value="d" /> <br>
	<c:choose>
		<c:when test="${str eq 'a'}">
			<c:out value="[CHOOSE] A" />
		</c:when>

		<c:when test="${str eq 'b'}">
			<c:out value="[CHOOSE] B" />
		</c:when>
		
		<c:when test="${str eq 'c'}">
			<c:out value="[CHOOSE] C" />
		</c:when>
		
		<c:otherwise>
			<c:out value="[CHOOSE] ETC" />
		</c:otherwise>
		
	</c:choose>
	
	<hr>
	<!-- forEach -->
	<c:set var="end" value="15" />
	<c:forEach var="i" begin="1" end="${end}" step="2">
		<c:out value="${i}" /> |
	</c:forEach>
	<hr>
	
	<%-- <c:set var="arr2" value="${['aaa','bbb','ccc','ddd','eee']}" /> 
	
	<c:forEach var="item" items="${arr2}" varStatus="status">
		${status.index} . ${item}  | count : ${status.count}<br>
	</c:forEach> --%>
	
	
	<%@page import="java.util.*" %>
	<%
		List<String> list = new ArrayList();
		list.add("JAVA");
		list.add("JSP");
		list.add("SERVLET");
		list.add("STS3 SPRINGFRAMEWORK");
		list.add("SPRING BOOT");
		request.setAttribute("list",list);
	%>
	Total : ${fn:length(list)} <br>
	<c:forEach var="item" items="${list}" varStatus="status">
		${status.index} . ${item}  | count : ${status.count}<br>
	</c:forEach>
	

</body>
</html>