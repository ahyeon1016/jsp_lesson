package Borad_Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========================================");
		System.out.println("[Board Create_Controller�� doGet() ����]");
		//��ó��
		HttpSession session = req.getSession(false);
		RequestDispatcher ds = null;
		if(session==null) {
			System.out.println("�α����ϼ���.");
			resp.sendRedirect("member_login");
		} else if(session != null) {
			Member mb =(Member)session.getAttribute("member");
			if(session.getAttribute("member")==null) {
				System.out.println("�������� ��� ����");
				ds=req.getRequestDispatcher("member_login");
			} else {
				ds=req.getRequestDispatcher("writeForm.jsp");
			}
			ds.forward(req, resp);
		} 

		//String id = req.getParameter("id");
		//�� �̵�
		//�� �̵�

		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Create_Controller�� doPost() ����]");

		
	}

}
