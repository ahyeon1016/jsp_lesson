<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id ="person" class ="chapter04.Person" scope ="request"/>
	<jsp:getProperty name="person" property="id"/><br>
	<jsp:getProperty name="person" property="name"/>
</body>
</html>