package Borad_Controller;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Date;

import org.apache.el.util.ConcurrentCache;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
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
		System.out.println("=========================================");
		System.out.println("[Board Create_Controller�� doPost() ����]");
		//��ó��
		HttpSession session = req.getSession(false);
		Member mb = (Member)session.getAttribute("member");
		
		String id = mb.getId();
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp regist_day = new java.sql.Timestamp(currentDatetime.getTime());
		
		int hit = 0;
		String ip = req.getRemoteAddr();
		
		System.out.println("�޾ƿ� �� : "+id+"/"+name+"/"+subject+"/"+content+"/"+regist_day+"/"+hit+"/"+ip);
		
		System.out.println("Board Set");
		Board bd = new Board();
		bd.setId(id);
		bd.setName(name);
		bd.setSubject(subject);
		bd.setContent(content);
		bd.setContent(content);
		bd.setRegist_day(regist_day);
		bd.setHit(hit);
		bd.setIp(ip);
		
		//���̵�
		System.out.println("�� �̵�");
		BoardRepository br = BoardRepository.getBr();
		br.create(bd);
		
		//���̵�
		resp.sendRedirect("BoardListAction");
	}

}
