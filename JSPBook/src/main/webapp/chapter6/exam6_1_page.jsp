<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList arr = (ArrayList)request.getAttribute("arr");
	String[] phone = (String[])arr.get(3);
	String[] hobby = (String[])arr.get(5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 결과</h3>
	<p> 아이디 : <%=arr.get(0)%>
	<p> 비밀번호 : <%=arr.get(1)%>
	<p> 이름 : <%=arr.get(2)%>
	<p> 전화 번호 : <%out.println(phone[0]+"-"+phone[1]+"-"+phone[2]);%>
	<p> 성별 : <%=arr.get(4)%> 
	<p> 취미 : <%out.println(hobby[0]+" "+hobby[1]+" "+hobby[2]);%>
</body>
</html>