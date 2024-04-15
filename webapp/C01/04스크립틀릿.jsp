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
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("행열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.print("행 : " + row + "열 : " + col);
	
%>
행 : <%=row %><br>
열 : <%=col %><br>
<hr>


</body>
</html>