<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name1 = (String) request.getAttribute("name1");
		String name2 = (String) request.getAttribute("name2");		
		String name3 = (String) request.getAttribute("name3");	
	
		String subject1 = (String) request.getAttribute("subject1");
		String subject2 = (String) request.getAttribute("subject2");
		String subject3 = (String) request.getAttribute("subject3");
		
		String file1 =(String)request.getAttribute("file1");
		String file2 =(String)request.getAttribute("file2");
		String file3 =(String)request.getAttribute("file3");
		
		String save =(String)request.getAttribute("save");
	%>


    이름 : <%= name1%> <br>
    제목 : <%= subject1%> <br>
    파일 : <%= file1%> <br> 
    <img src="img/<%=file1%>">
    <br>
	이름 : <%= name2%> <br>
    제목 : <%= subject2%> <br>
    파일 : <%= file2%> <br> 
    <img src="img/<%=file2%>">
    <br>
    이름 : <%= name3%> <br>
    제목 : <%= subject3%> <br>
    파일 : <%= file3%> <br> 
    <img src="img/<%=file3%>">
    <hr>
    경로 : <%=save %>
</body>
</html>