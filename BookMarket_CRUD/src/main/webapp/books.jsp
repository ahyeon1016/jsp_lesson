<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="dto.Book" %>
<% System.out.println("4: Books.jsp 뷰로 이동함"); %>
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
		<%
			ArrayList<Book> arr = (ArrayList<Book>) request.getAttribute("list");
			if(arr==null){
				System.out.println("5: 리스트 값을 전달 받지 못함");
			}
		%>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 목록</h1>
				<p class="col-md-8 fs-4">Book List</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch text-center">
			<%
				for(int i=0; i<arr.size(); i++){
					Book bk = arr.get(i);
					if(bk==null){
						System.out.println("");
					}
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">
					<img src="resources/img/<%=bk.getFilename()%>" style="width : 250px; height : 350px;">
					<h5><b><%=bk.getBookname()%></b></h5>
					<p> <%=bk.getAuthor()%>
					<p> <%=bk.getPublisher()%> | <%=bk.getUnitPrice()%>원
					<p> <%=bk.getBookdescription()%>...
					<p> <%=bk.getUnitsInStock()%>개
					<p> <a href= "book?id=<%=bk.getBookId()%>" class="btn btn-secondary" role="button">상세 정보</a>
				</div>
			</div>
			<%
				}
			%>
			<hr>
			<%--rs 주석
			<%
				for(int i=0; i<rs.size(); i++){
					Book book = rs.get(i);
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">
					<img src="resources/img/<%=book.getFilename()%>" style="width : 250px; height : 350px;">
					<h5><b><%=book.getBookname()%></b></h5>
					<p> <%=book.getAuthor()%>
					<p> <%=book.getPublisher()%> | <%=book.getUnitPrice()%>원
					<p> <%=book.getBookdescription()%>...
					<p> <%=book.getUnitsInStock()%>개
					<p> <a href= "book?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">상세 정보</a>
					<p> <a href= "update?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">수정하기</a>
					<p> <a href= "delete?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button">제거하기</a>
				</div>
			</div>
			<%
				}
			%>
			--%>
		</div>
		
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>