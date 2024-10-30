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
		System.out.println("[Delete_Controller doGet() ����]");
		//��ó��
		String bookId = req.getParameter("id");
		System.out.println("bookId�� �� : "+bookId);
		//�� �̵�
		BookRepository br = BookRepository.getInstance();
		br.delBook(bookId);
		//�� �̵�
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Delete_Controller doPost() ����]");

	}
	
}
