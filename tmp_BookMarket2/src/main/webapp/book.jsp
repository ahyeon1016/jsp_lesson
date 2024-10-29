<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="exceptioNoBookId.jsp" %>
<jsp:useBean id = "bookDAO" class = "dao.BookRepository" scope = "session"/>
<%
	session = request.getSession(false);
	ArrayList<Book> listOfBook = (ArrayList<Book>)session.getAttribute("arry");
	ArrayList<Book> rs = (ArrayList<Book>)session.getAttribute("rs");
%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>도서 정보</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp"%>
	
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		</div>
		
		<% 
			for(int i=0; i<listOfBook.size(); i++){
				Book book = listOfBook.get(i);
		%>
		
		<div class="row align-items-md-stretch mb-5">
			<div class="col-md-5">
				<img src = "resources/img/<%=book.getFilename()%>" style="width : 70%;">
			</div>
			<div class="col-md-6">
				<h3><b><%=book.getName() %></b></h3>
				<p><%=book.getDescription() %>
				<p> <b>도서코드 : </b><span class="badge text-bg-danger"><%=book.getBookId() %></span>
				<p> <b>저자</b> <%=book.getAuthor() %>
				<p> <b>출판사</b> <%=book.getPublisher() %>
				<p> <b>출판일</b> <%=book.getReleaseDate() %>
				<p> <b>분류</b> <%=book.getCategory() %>
				<p> <b>재고수</b> <%=book.getUnitsInStock() %>
				<h4><%=book.getUnitPrice() %></h4>
				<p> <form name="addForm" action="addCart?id=<%=book.getBookId()%>" method="post">
					<input type=submit class="btn btn-info" value="도서주문 &raquo;">				
					<a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
					<a href="products" class="btn btn-secondary">도서목록 &raquo;</a>
					</form>
			</div>
		</div>
		<%
			}
		%>
		
		<% 
			for(int i=0; i<rs.size(); i++){
				Book rsbook = rs.get(i);
		%>
		
		<div class="row align-items-md-stretch mb-5">
			<div class="col-md-5">
				<img src = "resources/img/<%=rsbook.getFilename()%>" style="width : 70%;">
			</div>
			<div class="col-md-6">
				<h3><b><%=rsbook.getName() %></b></h3>
				<p><%=rsbook.getDescription() %>
				<p> <b>도서코드 : </b><span class="badge text-bg-danger"><%=rsbook.getBookId() %></span>
				<p> <b>저자</b> <%=rsbook.getAuthor() %>
				<p> <b>출판사</b> <%=rsbook.getPublisher() %>
				<p> <b>출판일</b> <%=rsbook.getReleaseDate() %>
				<p> <b>분류</b> <%=rsbook.getCategory() %>
				<p> <b>재고수</b> <%=rsbook.getUnitsInStock() %>
				<h4><%=rsbook.getUnitPrice() %></h4>
				<p> <form action="addCart?id=<%=rsbook.getBookId()%>" method="post">
					<input type=submit class="btn btn-info" value="도서주문 &raquo;">				
					<a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
					<a href="products" class="btn btn-secondary">도서목록 &raquo;</a>
					</form>
			</div>
		</div>
		<%
			}
		%>
		<%@ include file = "footer.jsp" %>

	</div>
</body>
</html>