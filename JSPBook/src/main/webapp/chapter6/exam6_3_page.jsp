<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<String> arr = (ArrayList<String>)request.getAttribute("arr");
	String[] phone = (String[])request.getAttribute("phone");
	String[] hobby = (String[])request.getAttribute("hobby");
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
	<p> 성별 : <%=arr.get(3)%> 
	<p> 취미 : 
	<%
		for(int i=0; i<hobby.length; i++){
			if(hobby[i] != null){
				out.println(" "+hobby[i]);
			}
		}
	%>
	<p> 가입인사 : <%=arr.get(4)%>
</body>
</html>