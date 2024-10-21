<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>페이지 오류</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
			
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다..</h1>
			</div>
		</div>
		
		<div class="container">
			<p> <%=request.getRequestURL() %>
			<p> <a href="book" class="btn btn-secondary">도서 목록&rauqa;</a>
		</div>
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>