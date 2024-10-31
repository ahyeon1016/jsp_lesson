package Borad_Controller;

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
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========================================");
		System.out.println("[Board Create_Controller의 doGet() 도착]");
		//전처리
		HttpSession session = req.getSession(false);
		if(session==null) {
			System.out.println("로그인하세요.");
			resp.sendRedirect("member_login");
		}
		
		//String id = req.getParameter("id");
		//모델 이동
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("writeForm.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Create_Controller의 doPost() 도착]");

		
	}

}
