<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Exception e = (Exception)request.getAttribute("e");
	%>
	<p> 오류가 발생했습니다.
	<p> 예외 : <%=e %>
	<p> toString() : <%=e.toString() %>
	<p> getClass().getName() : <%=e.getClass().getName() %>
	<p> getMessage() : <%=e.getMessage() %>
</body>
</html>