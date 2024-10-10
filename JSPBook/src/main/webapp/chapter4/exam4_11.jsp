<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="chapter04.Person"></jsp:useBean>
	<jsp:setProperty name="person" property="id" value="20241016"/>
	<jsp:setProperty name="person" property="name" value="AGH"/>
	<p> 생일 : <jsp:getProperty name="person" property="id"/>
	<p> 이름 : <jsp:getProperty name="person" property="name"/>
</body>
</html>