package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_1")
public class exam05_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		System.out.println("전달 받은 id"+id);
		
		String passward = req.getParameter("passwd");
		System.out.println("전달 받은 패스워드:"+passward);
		
		req.setAttribute("id", id);
		req.setAttribute("pw", passward);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter5/exam5_1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
