<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="exceptioNoBookId.jsp" %>
<jsp:useBean id = "bookDAO" class = "dao.BookRepository" scope = "session"/>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>장바구니</title>
	<%
		String cartId=session.getId();
	%>
</head>
<body>
	<div class="container py-4">
	<%@ include file="menu.jsp" %>
	
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">장바구니</h1>
				<p class="col-md-8 fs-4">Cart</p>
			</div>
		</div>
	
		<div class="row align-items-md-stretch">
			<div class="row">
				<table width="100%">
					<tr>
						<td align="left"><a href="deleteCart.jsp?id=<%=cartId%>" class="btn btn-danger">삭제하기</a></td>	
						<td align="right"><a href="shippingInfo.jsp" class="btn btn-success">주문하기</a></td>	
					</tr>
				</table>
			</div>
			
			<div style="padding-top: 50px">
				<table class="table table-hover">
					<tr>
						<th>도서</th>
						<th>가격</th>
						<th>수량</th>
						<th>소계</th>
						<th>비고</th>
					</tr>
					<%
						int sum=0;
						ArrayList<Book> cartList=(ArrayList<Book>) session.getAttribute("cartlist");
						if(cartList==null){
							cartList=new ArrayList<Book>();
						}
						for(int i=0; i<cartList.size(); i++){
							Book book=cartList.get(i);
							int total = book.getUnitPrice() * book.getQuantity();
							sum=sum+total;
					
					%>
					  
					<tr>
						<td><%=book.getBookId() %>-<%=book.getName() %></td>
						<td><%=book.getUnitPrice() %></td>
						<td><%=book.getQuantity() %></td>
						<td><%=total %></td>
						<td><a href="deleteCart.jsp?id=<%=cartId%>">삭제</a></td>
					</tr>
					<%
					}
					%>
					<tr>
						<th></th>
						<th></th>
						<th>총액</th>
						<th><%=sum %></th>
						<th></th>
					</tr>
				</table>
				<a href="products" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
			</div>
		</div>
	
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>