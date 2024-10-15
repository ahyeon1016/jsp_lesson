<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> name=(ArrayList<String>)request.getAttribute("name");
		ArrayList<String> file=(ArrayList<String>)request.getAttribute("file");
	%>
	
	이름 : <%=name %>
	파일 : <%=file %>
	<img src="img/<%=file.get(1)%>">
</body>
</html>