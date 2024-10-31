package Member_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dao.MemberReopository;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_login")
public class Read_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===============================");
		System.out.println("[Read_Controller의 doGet 도착]");
		//전처리 
		
		//모델이동
		
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("loginMember.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===============================");
		System.out.println("[Read_Controller의 doPost 도착]");
		//전처리 
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		//모델이동
		MemberReopository mr = MemberReopository.getMr();
		Member mb = mr.getUser(id, password);
		
		if(mb!=null) { //DTO가 존재하므로 회원이 맞음
			//세션 생성
			HttpSession session = req.getSession(true);
			session.setAttribute("member", mb);
		} else {
			resp.sendRedirect("member_login?error=1");
		}
		//뷰 이동
		RequestDispatcher ds = req.getRequestDispatcher("resultMember.jsp?msg=2");
		ds.forward(req, resp);
	}

}
