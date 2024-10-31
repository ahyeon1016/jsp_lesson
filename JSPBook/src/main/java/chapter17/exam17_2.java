package chapter17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/17_2")
public class exam17_2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("17_2 doGet() 도착");
		//전처리x
		//모델이동x
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter17/exam17_2.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("17_2 doPost() 도착");
		//전처리
		String number = req.getParameter("number");
		System.out.println(number);
		//모델이동x
		//뷰이동
		req.setAttribute("num", number);
	
		RequestDispatcher ds = req.getRequestDispatcher("chapter17/exam17_2_view.jsp");
		ds.forward(req, resp);
	}

}
