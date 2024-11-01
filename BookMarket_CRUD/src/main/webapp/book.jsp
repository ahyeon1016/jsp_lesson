<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page errorPage="exceptioNoBookId.jsp" %>
<%@ page session="false" %>

<%
	System.out.println("[book.jsp 뷰 도착]");
	Book bk = (Book)request.getAttribute("dto");
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

		<div class="row align-items-md-stretch mb-5">
			<div class="col-md-5">
				<img src = "resources/img/<%=bk.getFilename() %>" style="width : 70%;">
			</div>
			<div class="col-md-6">
				<h3><b><%=bk.getBookname() %></b></h3>
				<p><%=bk.getBookdescription() %>
				<p> <b>도서코드 : </b><span class="badge text-bg-danger"><%=bk.getBookId() %></span>
				<p> <b>저자</b> <%=bk.getAuthor() %>
				<p> <b>출판사</b> <%=bk.getPublisher() %>
				<p> <b>출판일</b> <%=bk.getReleaseDate() %>
				<p> <b>분류</b> <%=bk.getCategory() %>
				<p> <b>재고수</b> <%=bk.getUnitsInStock() %>
				<h4><%=bk.getUnitPrice() %></h4>
				<p> <form name="addForm" action="addCart?id=<%=bk.getBookId()%>" method="post">
					<input type=submit class="btn btn-info" value="도서주문 &raquo;">				
					<a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
					<a href="products" class="btn btn-secondary">도서목록 &raquo;</a>
					</form>
			</div>
		</div>

		<%@ include file = "footer.jsp" %>

	</div>
</body>
</html>