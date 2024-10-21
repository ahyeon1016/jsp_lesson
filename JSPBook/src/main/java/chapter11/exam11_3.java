package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_3")
public class exam11_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post도착");
		
		RequestDispatcher ds =req.getRequestDispatcher("chapter11/exam11_3_isErrorPage.jsp");
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		try {
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			int c = a/b;
		} catch (Exception e) {
			System.out.println("예외 발생"+e);
			req.setAttribute("e", e);
			ds.forward(req, resp);
		}
		System.out.println("예외 없음");
	}

}
