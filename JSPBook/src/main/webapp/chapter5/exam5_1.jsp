
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
	    String userid =(String)request.getAttribute("id");
		String pwd =(String)	request.getAttribute("pw");
	%>

	<p> 아이디 : <%=userid %>
	<p> 비밀번호: <%=pwd %>
</body>
</html>