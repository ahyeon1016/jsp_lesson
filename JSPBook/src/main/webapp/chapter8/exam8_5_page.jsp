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
		String id=(String)request.getAttribute("id");
		String pwd=(String)request.getAttribute("pwd");
		String name=(String)request.getAttribute("name");
		String phone=(String)request.getAttribute("phone");
		String email=(String)request.getAttribute("email");
	%>
	<h3>회원가입 성공</h3>	
	<hr>
	<p> 아이디 : <%=id %>
	<p> 비밀번호 : <%=pwd %>
	<p> 이름 : <%=name %>
	<p> 전화번호 : <%=phone %>
	<p> 이메일 : <%=email %>
</body>
</html>