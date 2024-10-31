package Borad_Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dto.Board;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BoardListAction")
public class Read_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=======================================");
		System.out.println("[Board Read_Controller�� doGet() ����]");
		//��ó��
		//�� �������� ����� ���� ������ ������
		int Lemit = 5;
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		//�� �̵�
		BoardRepository br = BoardRepository.getBr();
		ArrayList<Board> arr = br.getAllBoard();
		if(arr==null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("arr�� ���� ����");
			resp.sendRedirect("welcome.jsp");
		}
		
		int total_record = br.getTotalCount();
		int total_page = 0;
		if(total_record%Lemit == 0) {
			total_page = total_record/Lemit;
		} else {
			total_page = (total_record/Lemit)+1;
		}
		
		//�� �̵�
		req.setAttribute("total_page", total_page); // ����� �������� ����
		req.setAttribute("total_record", total_record); // ��ü ���� ����
		req.setAttribute("pageNum", pageNum); //���� ������ ��ȣ
		req.setAttribute("list", arr); //��ü ���� ���� ��ü
		RequestDispatcher ds = req.getRequestDispatcher("list.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=======================================");
		System.out.println("[Read_Controller�� doPost() ����]");

		
	}

}
