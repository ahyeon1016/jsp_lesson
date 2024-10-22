package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_6")
public class exam13_6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_6.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		
		if(id.equals("admin")&&pwd.equals("1234")) {
			session.setAttribute("id",id);
			session.setAttribute("pwd", pwd);
			System.out.println("세션 설정 성공");
			System.out.println(id+"님 환영합니다.");
		} else {
			System.out.println("세션 설정 실패");
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_6_process.jsp");
		ds.forward(req, resp);
	}
	
}
