package chapter07;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_1_연습")
public class exam07_1_연습 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter7/exam7_1_test.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String save = req.getServletContext().getRealPath("img");
		
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024,"utf-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String file = multi.getFilesystemName("filename");
		
		System.out.println(save);
		System.out.println(name);
		System.out.println(subject);
		System.out.println(file);
		
		req.setAttribute("name", name);
		req.setAttribute("subject", subject);
		req.setAttribute("file", file);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter7/exam7_1_test_process.jsp");
		ds.forward(req, resp);
	}
	
}
