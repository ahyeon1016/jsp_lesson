package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/8_5")
public class exam08_5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter8/exam8_5.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		String id = req.getParameter("id"); 
		String pwd = req.getParameter("pwd"); 
		String name = req.getParameter("name"); 
		String p1 = req.getParameter("phone1"); 
		String p2 = req.getParameter("phone2"); 
		String p3 = req.getParameter("phone3");
		String phone = (p1+"-"+p2+"-"+p3);
		String email = req.getParameter("email"); 
		
		System.out.println("아이디 : "+id+"\n비밀번호 : "+pwd+"\n이름 : "+name+"\n전화번호 : "+phone+"\n이메일 :"+email);
		
		req.setAttribute("id", id);
		req.setAttribute("pwd", pwd);
		req.setAttribute("name", name);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter8/exam8_5_page.jsp");
		ds.forward(req, resp);
	}
	
}
