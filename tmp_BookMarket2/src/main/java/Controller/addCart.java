package Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addCart")
public class addCart extends HttpServlet{	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addCart 컨트롤러 도착");
		
		HttpSession session=req.getSession();;
		
		if(session==null) {
			System.out.println("session = null");
			session = req.getSession(true);
		}

		String id = req.getParameter("id");

		if(id==null || id.trim().equals("")) {
			System.out.println("id = null");
			resp.sendRedirect("products");
			return;
		}
		
		BookRepository dao = BookRepository.getInstance();
		
		Book book = dao.getBookById(id);
		if(book==null) {
			System.out.println("book = null");
			resp.sendRedirect("exceptionNoBookId.jsp");
		}
		
		ArrayList<Book> goodsList = dao.getAllBooks();
		Book goods = new Book();
		for(int i=0; i<goodsList.size(); i++) {
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id)) {
				break;
			}
		}
		
		ArrayList<Book> list =(ArrayList<Book>) session.getAttribute("cartlist");
		if(list==null) {
			System.out.println("list = null");
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		
		int cnt=0;
		Book goodsQnt = new Book();
		for(int i=0; i<list.size(); i++) {
			goodsQnt=list.get(i);
			if(goodsQnt.getBookId().equals(id)){
				cnt++;
				int orderQuantity = goodsQnt.getQuantity()+1;
				goodsQnt.setQuantity(orderQuantity);
			}
			
		}
		
		if(cnt==0) {
			System.out.println("cnt = 0");
			goods.setQuantity(1);
			list.add(goods);
		}
		
		resp.sendRedirect("products");
	}

}
