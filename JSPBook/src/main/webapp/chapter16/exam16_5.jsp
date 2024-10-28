<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="chapter16.dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<dto> arr = (ArrayList<dto>)request.getAttribute("arr");
	%>
	<table width="300" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%
			for(int i=0; i<arr.size();i++){
				dto d1 = arr.get(i);
		%>
		<tr>
			<th><%=d1.getId() %></th>
			<th><%=d1.getPwd() %></th>
			<th><%=d1.getName() %></th>
		</tr>
		<%}%>
	</table>
</body>
</html>