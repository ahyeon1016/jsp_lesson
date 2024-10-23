<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.Book" %>
<%@ page import = "dao.BookRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="exceptioNoBookId.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		System.out.println(id);
		if(id==null || id.trim().equals("")) {
			response.sendRedirect("products");
			return;
		}
		
		BookRepository dao = BookRepository.getInstance();

		Book book = dao.getBookById(id);
		System.out.print(book);
		if(book==null) {
			System.out.print("이상");
			response.sendRedirect("exceptionNoBookId.jsp");
			return;
		}
		ArrayList<Book> goodsList = dao.getAllBooks();
		Book goods = new Book();
		for(int i=0; i<goodsList.size(); i++) {
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id)) {
				break;
			}
		}
		ArrayList<Book> list =(ArrayList<Book>) session.getAttribute("cartlist");
		if(list==null) {
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}

		int cnt=0;
		Book goodsQnt = new Book();
		for(int i=0; i<list.size(); i++) {
			goodsQnt=list.get(i);
			if(goodsQnt.getBookId().equals(id)){
				cnt++;
				int orderQuantity = goodsQnt.getQuantity()+1;
				goodsQnt.setQuantity(orderQuantity);
			}
			
		}

		if(cnt==0) {
			goods.setQuantity(1);
			list.add(goods);
		}
		
		response.sendRedirect("products");
	%>
</body>
</html>