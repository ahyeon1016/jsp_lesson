package Controller;

import java.io.IOException;
import java.sql.ResultSet;
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
		//Verify Step 1 : 콘솔 찍어서 잘 매핑이 되는지 확인
		System.out.println("/product 매핑됨");
		
		//전처리
		
		//모델
		ArrayList<Book> arr = BookRepository.getAllBooks();
		
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> readList = br.readBook();
		
		//이동
		req.setAttribute("rs", readList);
		// 데이터 보낼 때      키     값
		req.setAttribute("arry", arr);
		RequestDispatcher ds = req.getRequestDispatcher("books.jsp");
		ds.forward(req, resp);
		
	}
}
