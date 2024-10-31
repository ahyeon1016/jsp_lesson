<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String number = (String)request.getAttribute("num");
	%>
	<c:set var="num" value="<%=number%>"/>
	<c:choose>
		<c:when test="${num%2==0}">
			<c:out value="${num}"/>는 짝수입니다.
		</c:when>
		<c:when test="${num%2==1}">
			<c:out value="${num}"/>는 홀수입니다.
		</c:when>
		<c:otherwise>
			숫자가 아닙니다.
		</c:otherwise>
	</c:choose>
</body>
</html>