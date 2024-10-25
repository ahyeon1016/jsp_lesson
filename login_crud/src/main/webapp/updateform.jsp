<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		member_dto dto = (member_dto)request.getAttribute("DTO");
	%>
	<h1>수정할 정보</h1>
	<p>ID : <%=dto.getId()%>
	<p>PWD : <%=dto.getPwd()%>
	<p>age : <%=dto.getAge()%>
	<form action="update" method="post">
		<p> ID : <input type="text" name="id" value="<%=dto.getId()%>" readonly="readonly">
		<p> PWD : <input type="text" name="pwd" value="<%=dto.getPwd()%>">
		<p> age : <input type="text" name="age" value="<%=dto.getAge()%>">
		<p> <input type="submit" value="수정">
	</form>
</body>
</html>