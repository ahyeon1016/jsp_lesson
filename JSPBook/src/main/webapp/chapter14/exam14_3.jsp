<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>ㅎㅇ</h3>
	<%
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
		response.sendRedirect("14_2");
	%>
</body>
</html>