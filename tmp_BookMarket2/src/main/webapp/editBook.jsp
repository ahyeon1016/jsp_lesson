<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="java.sql.ResultSet" %>
<%
	Book book = (Book) request.getAttribute("book");
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value='<%=request.getParameter("language")%>'/>
<fmt:bundle basename="bundle.message">
	<div class="container py-4">
		<%@include file = "menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold"><fmt:message key="title"/></h1>
				<p class="col-md-8 fs-4">Book Addition</p>
			</div>
		</div>
		
		<div class="row align-item-md-stretch">
			<div class="text-end">
				<a href="?language=ko">Korean</a>|<a href="?language=en">English</a>
				<a href="logout.jsp" class="btn btn-sm btn-success pull right">logout</a>
			</div>
			<form action="update" method="post" enctype="multipart/form-data" class="form-horizontal" name="addBook">
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookId"/></label>
					<div class="col-sm-3">
						<input type="text" name="bookId" class="form-control" id="bookId" value="<%=book.getBookId() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="name"/></label>
					<div class="col-sm-3">
						<input type="text" name="name" class="form-control" id="name" value="<%=book.getName() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
					<div class="col-sm-3">
						<input type="text" name="unitPrice" class="form-control" id="unitPrice" value="<%=book.getUnitPrice() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="author"/></label>
					<div class="col-sm-3">
						<input type="text" name="author" class="form-control" id="author" value="<%=book.getAuthor() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="publisher"/></label>
					<div class="col-sm-3">
						<input type="text" name="publisher" class="form-control" id="publisher" value="<%=book.getPublisher() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
					<div class="col-sm-3">
						<input type="text" name="releaseDate" class="form-control" id="releaseDate" value="<%=book.getReleaseDate() %>">
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="description"/></label>
					<div class="col-sm-5">
						<textarea name="description" rows="2" cols="50" class="form-control" id="description"><%=book.getDescription()%></textarea>
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="category"/></label>
					<div class="col-sm-3">
						<input type="text" name="category" class="form-control" id="category" value="<%=book.getCategory() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitInStock"/></label>
					<div class="col-sm-3">
						<input type="text" name="unitInStock" class="form-control" id="unitInStock" value="<%=book.getUnitsInStock() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="condition"/></label>
					<div class="col-sm-5">
						<input type="radio" name="condition" value="New" checked><fmt:message key="condition_New"/>
						<input type="radio" name="condition" value="Old"><fmt:message key="condition_Old"/>
						<input type="radio" name="condition" value="Ebook"><fmt:message key="condition_EBook"/>
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookFile"/></label>
					<div class="col-sm-3">
						<input type="file" name="bookFile" class="form-control" value="<%=book.getFilename() %>">
					</div>
				</div>
				<div class="mb-3 row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" class="btn btn-primary" value="<fmt:message key="button"/>" id="btn">
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			var btn = document.querySelector("#btn");
			btn.addEventListener("click", add);
	
			function add(){
				var addBook = document.addBook;
				
				var bookId = document.querySelector("#bookId").value;
				var name = document.querySelector("#name").value;
				var unitPrice = document.querySelector("#unitPrice").value;
				var description = document.querySelector("#description").value;
				var unitInStock = document.querySelector("#unitInStock").value;
	
				console.log(bookId);
				console.log(name);
				console.log(unitPrice);
				console.log(description);
				console.log(unitInStock);
				
				//도서 아이디 체크
				var regExpBookId = /^ISBN[0-9]{4,11}$/;
				if( !regExpBookId.test(bookId) ){
					alert("[도서코드]\nISBN과 숫자를 조합하여 5~12자 까지 입력하세요. \n첫 글자는 반드시 ISBN로 시작하세요!");
					addBook.bookId.select();
					return false;
				}
				console.log("bookId 통과");
				
				//도서명 체크
				if(name.length<4||name.length>50){
					alert("[도서명]\n최소 4자에서 최대 50자까지 입력하세요.")
					addBook.name.select();
					return false;
				}
				console.log("name 통과");
				
				//도서 가격 체크
				if(unitPrice<0){
					alert("[가격]\n음수를 입력할 수 없습니다.");
					addBook.unitPrice.focus();
					return false;
				}
				
				if(unitPrice.length==0 || isNaN(unitPrice)){
					alert("[가격]\n숫자만 입력하세요.");
					addBook.unitPrice.focus();
					return false;
				}
				console.log("unitPrice 통과");
				
				//상세정보 체크
				if(description.length<30){
					alert("[상세설명]\n최소 30자 이상 입력하세요.");
					addBook.description.focus();
					return false;	}
				
				//재고 수 체크
				if(unitInStock.length==0||isNaN(unitInStock)){
					alert("[재고 수]\n숫자만 입력하세요.");
					addBook.unitInStock.focus();
					return false;
				}
				console.log("unitInStock 통과");
				alert("책을 수정 합니다");
				addBook.submit();
			}
		</script>
		<%@include file = "footer.jsp" %>
	</div>
</fmt:bundle>
</body>
</html>