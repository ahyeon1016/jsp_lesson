<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="chapter16.dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		dto d1 = (dto)request.getAttribute("dto");
	%>
	<form action="16_7" method="post">
		<p> <input type="text" name="id" value="<%=d1.getId()%>" readonly>
		<p>	<input type="text" name="pwd" value="<%=d1.getPwd()%>">
		<p>	<input type="text" name="name" value="<%=d1.getName()%>">
		<p>	<input type="submit" value="전송">
	</form>
</body>
</html>