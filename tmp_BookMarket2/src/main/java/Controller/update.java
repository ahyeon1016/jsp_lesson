package Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update get µµÂø");
		//ÀüÃ³¸®
		String id = req.getParameter("id");
		System.out.println(id);
		
		//¸ðµ¨ ÀÌµ¿
		BookRepository rs = BookRepository.getInstance();
		Book book = rs.readOneBook(id);
		
		//ºä ÀÌµ¿
		req.setAttribute("book", book);
		RequestDispatcher ds = req.getRequestDispatcher("editBook.jsp");	
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update post µµÂø");
		
		String save = req.getServletContext().getRealPath("resources/img");
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitInStock = multi.getParameter("unitInStock");
		String condition = multi.getParameter("condition");
		String file = multi.getFilesystemName("bookFile");
		
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
		newBook.setFilename(file);
		
		BookRepository br = BookRepository.getInstance();
		br.updateBook(newBook);
		
		System.out.println("È®ÀÎ");
	}

}
