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
		String name=(String)request.getAttribute("name");
		String subject=(String)request.getAttribute("subject");
		String file=(String)request.getAttribute("file");
	%>
	
	파일이름 : <%=name %>
	파일제목 : <%=subject %>
	파일경로 : <%=file %>
	<p><img src="img/<%=file%>"></p>
</body>
</html>