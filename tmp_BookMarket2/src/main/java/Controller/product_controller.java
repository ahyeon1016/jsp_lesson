package Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/products")
public class product_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Verify Step 1 : �ܼ� �� �� ������ �Ǵ��� Ȯ��
		System.out.println("/product ���ε�");
		
		//��ó��

		
		//��
		ArrayList<Book> arr = BookRepository.getAllBooks();
		
		//�̵�
		// ������ ���� ��      Ű     ��
		req.setAttribute("arry", arr);
		RequestDispatcher ds = req.getRequestDispatcher("books.jsp");
		ds.forward(req, resp);
		
	}
}
