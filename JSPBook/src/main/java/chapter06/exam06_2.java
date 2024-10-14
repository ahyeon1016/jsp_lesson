package chapter06;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/6_2")
public class exam06_2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter6/exam6_2.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		System.out.println("post 도착");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] phone = {req.getParameter("phone1"), req.getParameter("phone2"), req.getParameter("phone3")};
		String sex = req.getParameter("sex");
		String[] hobby = {req.getParameter("hobby1"), req.getParameter("hobby2"), req.getParameter("hobby3")}; 
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(phone[0]+"-"+phone[1]+"-"+phone[2]);
		System.out.println(sex);
		System.out.println(hobby[0]+hobby[1]+hobby[2]);
		
		ArrayList arr = new ArrayList();
		arr.add(id);
		arr.add(pwd);
		arr.add(name);
		arr.add(phone);
		arr.add(sex);
		arr.add(hobby);
		
		req.setAttribute("arr", arr);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter6/exam6_2_page.jsp");
		ds.forward(req, resp);
	}
	
}
