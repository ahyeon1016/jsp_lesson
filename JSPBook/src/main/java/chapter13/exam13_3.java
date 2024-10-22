package chapter13;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_3")
public class exam13_3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id.equals("admin") && pwd.equals("1234")) {
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			System.out.println("세션 설정이 성공했습니다.");
			System.out.println(id+"님 환영합니다.");
		} else {
			System.out.println("세션 설정 실패 다시 입력하세요.");
		}
		
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_3_process.jsp");
		ds.forward(req, resp);
	}

}
