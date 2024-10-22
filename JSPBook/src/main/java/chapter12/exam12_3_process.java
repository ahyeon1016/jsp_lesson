package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_3_process")
public class exam12_3_process extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("폼 전송 컨트롤러 도착");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println("아이디 : "+id);
		System.out.println("비밀번호 : "+pwd);
		
		req.setAttribute("id", id);
		req.setAttribute("pwd", pwd);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/exam12_3_process.jsp");
		ds.forward(req, resp);
	}
	
}
