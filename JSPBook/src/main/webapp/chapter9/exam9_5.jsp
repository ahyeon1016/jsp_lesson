<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date now = (Date)request.getAttribute("now");
	%>
	<jsp:useBean id="now1" class="java.util.Date"></jsp:useBean>
	<h3>나라별 시간</h3>
	<p> 한국 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
	<p> <fmt:timeZone value="America/New_York">
		뉴욕 : <fmt:formatDate value="${now1}" type="both" dateStyle="full" timeStyle="full"/>
		</fmt:timeZone>
	<p> <fmt:timeZone value="Europe/London">
		런던 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
		</fmt:timeZone>
</body>
</html>