package chapter16;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_7")
public class exam16_7 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_7 get 도착");
		//전처리
		String id = req.getParameter("id");
		System.out.println(id);
		
		//모델 이동
		repository repo = repository.getInstance();
		dto d1 = repo.getOnemember(id);
		
		//뷰 이동
		req.setAttribute("dto", d1);
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_7.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("16_7 post 도착");
		//전처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		dto d1 = new dto();
		d1.setId(id);
		d1.setPwd(pwd);
		d1.setName(name);
		
		//모델 이동
		repository repo = repository.getInstance();
		repo.updateMember(d1);
		
		//뷰 이동
		resp.sendRedirect("16_5");
		
	}

}
