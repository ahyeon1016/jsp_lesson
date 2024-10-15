<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="fileForm" action="7_2" method="post" enctype="multipart/form-data">
		<p> 이름 : <input type="text" name="name1">
		<p> 제목 : <input type="text" name="subject1">
		<p> 파일 : <input type="file" name="filename1">
		<br>
		<p> 이름 : <input type="text" name="name2">
		<p> 제목 : <input type="text" name="subject2">
		<p> 파일 : <input type="file" name="filename2">
		<br>
		<p> 이름 : <input type="text" name="name3">
		<p> 제목 : <input type="text" name="subject3">
		<p> 파일 : <input type="file" name="filename3">
		
		<p> <input type="submit" value="파일 올리기">
	</form>
</body>
</html>