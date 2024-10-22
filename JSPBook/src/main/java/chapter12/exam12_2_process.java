package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_2_process")
public class exam12_2_process extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("프로세스 도착");
		
		String id01 = req.getParameter("id");
		String pwd01= req.getParameter("pwd");
		
		req.setAttribute("id01", id01);
		req.setAttribute("pwd01", pwd01);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/exam12_2_process.jsp");
		ds.forward(req, resp);
	}

}
