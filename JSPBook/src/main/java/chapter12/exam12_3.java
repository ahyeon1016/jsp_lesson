package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_3")
public class exam12_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("폼 페이지로 이동하기 위한 컨트롤러 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/exam12_3.jsp");
		ds.forward(req, resp);
	}

}
