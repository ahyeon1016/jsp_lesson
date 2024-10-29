package Controller;

import java.io.IOException;

import dao.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete get µµÂø");
		//ÀüÃ³¸®
		String id = req.getParameter("id");
		System.out.println(id);
		//¸ðµ¨ÀÌµ¿
		BookRepository br = BookRepository.getInstance();
		br.deleteBook(id);
		//ºäÀÌµ¿
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
