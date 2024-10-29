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
		System.out.println("delete get ����");
		//��ó��
		String id = req.getParameter("id");
		System.out.println(id);
		//���̵�
		BookRepository br = BookRepository.getInstance();
		br.deleteBook(id);
		//���̵�
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
