package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_8")
public class exam05_8 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter5/exam5_8.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		String userId = req.getParameter("id");
		String password = req.getParameter("pwd");
		
		req.setAttribute("userId", userId);
		req.setAttribute("password", password);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter5/exam5_8_page.jsp");
		ds.forward(req, resp);
	}
	
}
