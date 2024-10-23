<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="exceptioNoBookId.jsp" %>
<jsp:useBean id = "bookDAO" class = "dao.BookRepository" scope = "session"/>
<%
	ArrayList<Book> listOfBook = (ArrayList<Book>)request.getAttribute("arry");
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
				<p> <b>저자</b> <%=book.getAuther() %>
				<p> <b>출판사</b> <%=book.getPublisher() %>
				<p> <b>출판일</b> <%=book.getReleaseDate() %>
				<p> <b>분류</b> <%=book.getCategory() %>
				<p> <b>재고수</b> <%=book.getUnitsInStock() %>
				<h4><%=book.getUnitPrice() %></h4>
				
				<p> <form name="addForm" action="addCart.jsp?id=<%=book.getBookId()%>" method="post" id="addForm">
					<a href="#" class="btn btn-info" id="addToCart"> 도서주문 &raquo;</a>
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
	<script type="text/javascript">
		var addForm = document.querySelector("#addForm");
		var add = document.querySelector("#addToCart");
		add.addEventListener("click", addToCart);
			
		function addToCart() {
			if(confirm("도서를 장바구니에 추가하시겠습니까?")){
				console.log("추가한다.");
				addForm.submit();
			}else{
				console.log("추가하지 않는다.");
				addForm.reset();
			}
		}
	</script>
</body>
</html>