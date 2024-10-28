package chapter16;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_3")
public class exam16_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_3 get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_3 post 도착");
		//전처리
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		dto d1 = new dto();
		d1.setId(id);
		d1.setPwd(pwd);
		d1.setName(name);
		//모델 이동
		repository repo = repository.getInstance();
		repo.createMember_pstmt(d1);
		
		resp.sendRedirect("index.jsp");
	}

} 
