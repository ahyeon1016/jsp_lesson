<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name =(String) request.getAttribute("filename");
		String type =(String) request.getAttribute("type");
		File file =(File) request.getAttribute("file");
	%>
	이름 : <%=name %>
	타입 : <%=type %>
	파일 : <%=file %>
	<img src="C:\\upload<%=file%>">
</body>
</html>