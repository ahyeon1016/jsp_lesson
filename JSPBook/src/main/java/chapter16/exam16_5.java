package chapter16;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_5")
public class exam16_5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_5 get 도착");
		
		//전처리 x
		
		//모델 이동
		repository repo = repository.getInstance();
		ArrayList<dto> arr = repo.getMember();
		
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_5.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
