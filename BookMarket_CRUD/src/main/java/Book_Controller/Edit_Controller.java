package Book_Controller;

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

@WebServlet("/editBook")
public class Edit_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Edit_Controller doGet 이동]");
		//전처리
		String edit = req.getParameter("edit");
		System.out.println(edit);
		//모델 이동
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> arr  = br.getAllBooks();
		if(arr==null) {
			System.out.println("arr=null");
		}
		//뷰 이동
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		req.setAttribute("list", arr);
		req.setAttribute("edit", edit);
		RequestDispatcher ds = req.getRequestDispatcher("editBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Edit_Controller doPost 이동]");

	}

}
