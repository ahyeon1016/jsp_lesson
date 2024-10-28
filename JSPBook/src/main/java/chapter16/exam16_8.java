package chapter16;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_8")
public class exam16_8 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_8 get 도착");
		//전처리
		String id = req.getParameter("id");
		System.out.println(id);
		
		//모델 이동
		repository repo = repository.getInstance();
		repo.deleteMember(id);
				
		//뷰 이동
		resp.sendRedirect("16_5");
	}
}