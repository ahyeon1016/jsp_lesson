package Book_Controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class Read_one_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Read_one_Controller의 doGet() 도착");
		//전처리
		String bookId = req.getParameter("id");
		System.out.println("id : "+bookId);
		
		//모델 이동
		BookRepository br = BookRepository.getInstance();
		Book dto = br.getBookById(bookId);
		if(dto==null) {
			System.out.println("dto에 ResultSet의 정보가 담기지 않음");
		}
		//뷰 이동
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		req.setAttribute("dto", dto);
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
