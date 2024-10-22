<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>----------세션 삭제 전-------</h4>
	<%	
		session = request.getSession(false);
		String id = (String)session.getAttribute("id");	
		String pwd = (String)session.getAttribute("pwd");
		out.print("설정된 세션 이름 id : "+id+"<br>" );
		out.print("설정된 세션 값 pwd : "+pwd+"<br>");
		
		session.removeAttribute("id");
	%>
	<h4>----------세션 삭제 후-------</h4>
	<%	
		id = (String)session.getAttribute("id");	
		pwd = (String)session.getAttribute("pwd");
		out.print("설정된 세션 이름 id : "+id+"<br>" );
		out.print("설정된 세션 값 pwd : "+pwd+"<br>");
	%>
</body>
</html>