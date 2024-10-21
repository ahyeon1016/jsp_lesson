package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_1_process")
public class exam12_1_process extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		String name = req.getParameter("name");
		System.out.println("이름 : "+name);
		
		req.setAttribute("name", name);
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/exam12_1_process.jsp");
		ds.forward(req, resp);
	}

}
