<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="dto.Book" %>
<% System.out.println("[editBook.jsp 뷰로 이동함]"); %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
<title>도서 목록</title>
<script type="text/javascript">
	function deleteConfirm(id) {
		if (confirm("해당 상품을 삭제합니다!!") == true)
			location.href = "deleteBook?id=" + id;
		else
			return;
	}
</script>
</head>
<body>
	<div class="container py-4">
		<%@include file="menu.jsp"%>
		<%
			ArrayList<Book> arr = (ArrayList<Book>) request.getAttribute("list");
			String edit = (String) request.getAttribute("edit");
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
						System.out.println("bk = null");
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
					<p>	<%			
							if(edit.equals("update")){
						%>
					    <a href= "updateBook?id=<%=bk.getBookId()%>" class="btn btn-success" role="button">수정 &raquo;</a>
					    <%
							} else if(edit.equals("delete")) {
					    %>
					    <a href= "#" onclick="deleteConfirm('<%=bk.getBookId()%>')" class="btn btn-danger" role="button">삭제(JS) &raquo;</a>
					    <a href= "delete?id=<%=bk.getBookId()%>"  class="btn btn-danger" role="button">삭제(바로) &raquo;</a>
					    <%
							}
					    %>
				</div>
			</div>
			<%
				}
			%>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>