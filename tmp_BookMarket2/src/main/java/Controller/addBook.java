package Controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class addBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addBook get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("addBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addBook post 도착");
		
		String bookId = req.getParameter("bookId");
		String name = req.getParameter("name");
		String unitPrice = req.getParameter("unitPrice");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String releaseDate = req.getParameter("releaseDate");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		String unitInStock = req.getParameter("unitInStock");
		String condition = req.getParameter("condition");
		
		Integer price;
		
		if(unitPrice.isEmpty()) {
			price=0;
		} else {
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitInStock.isEmpty()) {
			stock=0;
		} else {
			stock = Long.valueOf(unitInStock);
		}
		
		BookRepository dao = BookRepository.getInstance();
		
		Book newBook = new Book();
		
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setUnitPrice(price);
		newBook.setAuther(author);
		newBook.setPublisher(publisher);
		newBook.setReleaseDate(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		
		dao.addBook(newBook);
		
		resp.sendRedirect("products");
	}
	
}
