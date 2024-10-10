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
	<jsp:setProperty name="person" property ="id" value ="70345"/>
	<jsp:setProperty name="person" property="name" value ="FryDay" />
	<p> 아이디 : <%=person.getId() %>
	<p> 이름 : <%=person.getName() %>
</body>
</html>