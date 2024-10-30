package Book_Controller;

import java.io.IOException;

import dao.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class Delete_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Delete_Controller doGet() 紫雜]");
		//瞪籀葬
		String bookId = req.getParameter("id");
		System.out.println("bookId曖 高 : "+bookId);
		//賅筐 檜翕
		BookRepository br = BookRepository.getInstance();
		br.delBook(bookId);
		//箔 檜翕
		System.out.println("天天天天天天天天天天天天天天天天天天");
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Delete_Controller doPost() 紫雜]");

	}
	
}
