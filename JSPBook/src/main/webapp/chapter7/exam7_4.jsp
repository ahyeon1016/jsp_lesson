<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="7_4" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name">
		제목 : <input type="text" name="subject">
		파일 : <input type="file" name="filename">
		<input type="submit" value="파일 올리기">
	</form>
</body>
</html>