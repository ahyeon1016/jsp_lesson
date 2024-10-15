<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>요청 파라미터 이름</th>
			<th>요청 파라미터 값</th>
		</tr>
		<%
			request.setCharacterEncoding("utf-8");	
		
			Enumeration paramName = request.getParameterNames();
			
			while(paramName.hasMoreElements()){
				String name = (String)paramName.nextElement();
				out.print("<tr><td>"+name+"</td>\n>");
				String paramValue =request.getParameter(name);
				out.print("<td>"+paramValue+"</td></tr>");
			}
		%>
	</table>
</body>
</html>