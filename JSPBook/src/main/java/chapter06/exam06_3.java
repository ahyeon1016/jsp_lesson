package chapter06;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/6_3")
public class exam06_3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter6/exam6_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] phone = req.getParameterValues("phone");
		String sex = req.getParameter("sex");
		String[] hobby = req.getParameterValues("hobby");
		String comment = req.getParameter("comment");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(sex);
		System.out.println(hobby);
		System.out.println(comment);
		
		ArrayList arr = new ArrayList();
		arr.add(id);
		arr.add(pwd);
		arr.add(name);
		arr.add(sex);
		arr.add(comment);
		
		req.setAttribute("arr", arr);
		req.setAttribute("phone", phone);
		req.setAttribute("hobby", hobby);
		
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter6/exam6_3_page.jsp");
		ds.forward(req, resp);
	}
	
}
