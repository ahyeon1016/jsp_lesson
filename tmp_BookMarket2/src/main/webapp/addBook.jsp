<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form action="addBook" method="post" enctype="multipart/form-data" class="form-horizontal" name="addBook">
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookId"/></label>
					<div class="col-sm-3">
						<input type="text" name="bookId" class="form-control" id="bookId">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="name"/></label>
					<div class="col-sm-3">
						<input type="text" name="name" class="form-control" id="name">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
					<div class="col-sm-3">
						<input type="text" name="unitPrice" class="form-control" id="unitPrice">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="author"/></label>
					<div class="col-sm-3">
						<input type="text" name="author" class="form-control" id="author">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="publisher"/></label>
					<div class="col-sm-3">
						<input type="text" name="publisher" class="form-control" id="publisher">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
					<div class="col-sm-3">
						<input type="text" name="releaseDate" class="form-control" id="releaseDate">
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="description"/></label>
					<div class="col-sm-5">
						<textarea name="description" rows="2" cols="50" class="form-control" placeholder="100자 이상 적어주세요" id="description"></textarea>
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="category"/></label>
					<div class="col-sm-3">
						<input type="text" name="category" class="form-control" id="category">
					</div>
				</div>
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitInStock"/></label>
					<div class="col-sm-3">
						<input type="text" name="unitInStock" class="form-control" id="unitInStock">
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
						<input type="file" name="bookFile" class="form-control">
					</div>
				</div>
				<div class="mb-3 row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" class="btn btn-primary" value="<fmt:message key="button"/>" id="btn">
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="resources/js/validation.js"></script>
		<%@include file = "footer.jsp" %>
	</div>
</fmt:bundle>
</body>
</html>