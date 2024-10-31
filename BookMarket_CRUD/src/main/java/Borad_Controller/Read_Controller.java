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
		System.out.println("[Board Read_Controller의 doGet() 도착]");
		//전처리
		//한 페이지에 출력할 글의 갯수를 제한함
		int Lemit = 5;
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		//모델 이동
		BoardRepository br = BoardRepository.getBr();
		ArrayList<Board> arr = br.getAllBoard();
		if(arr==null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("arr에 값이 없음");
			resp.sendRedirect("welcome.jsp");
		}
		
		int total_record = br.getTotalCount();
		int total_page = 0;
		if(total_record%Lemit == 0) {
			total_page = total_record/Lemit;
		} else {
			total_page = (total_record/Lemit)+1;
		}
		
		//뷰 이동
		req.setAttribute("total_page", total_page); // 출력할 페이지의 갯수
		req.setAttribute("total_record", total_record); // 전체 글의 갯수
		req.setAttribute("pageNum", pageNum); //현재 페이지 번호
		req.setAttribute("list", arr); //전체 글을 담은 객체
		RequestDispatcher ds = req.getRequestDispatcher("list.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=======================================");
		System.out.println("[Read_Controller의 doPost() 도착]");

		
	}

}
