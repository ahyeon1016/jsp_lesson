<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%
	ArrayList<Book> listOfBooks = (ArrayList<Book>)request.getAttribute("arry");
%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
	<div class="container py-4">
		<%@include file="menu.jsp"%>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 목록</h1>
				<p class="col-md-8 fs-4">Book List</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch text-center">
			<%
				for(int i=0; i<listOfBooks.size(); i++){
					Book book = listOfBooks.get(i);
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">
					<img src="resources/img/<%=book.getFilename()%>" style="width : 250px; height : 350px;">
					<h5><b><%=book.getName()%></b></h5>
					<p> <%=book.getAuther()%>
					<p> <%=book.getPublisher()%> | <%=book.getUnitPrice()%>원
					<p> <%=book.getDescription()%>...
					<p> <%=book.getUnitsInStock()%>개
					<p> <a href= "book?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">상세 정보</a>
				</div>
			</div>
			<%
				}
			%>
		</div>
		
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>