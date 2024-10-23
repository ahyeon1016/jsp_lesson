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
		System.out.println("0");
		HttpSession session=null;
		System.out.println("00");
		if(session==null) {
			session = req.getSession(true);
		}
		System.out.println("1");
		String id = req.getParameter("id");
		System.out.println(id);
		if(id==null || id.trim().equals("")) {
			resp.sendRedirect("products");
			return;
		}
		
		BookRepository dao = BookRepository.getInstance();
		System.out.println("2");
		Book book = dao.getBookById(id);
		if(book==null) {
			resp.sendRedirect("exceptionNoBookId.jsp");
		}
		System.out.println("3");
		ArrayList<Book> goodsList = dao.getAllBooks();
		Book goods = new Book();
		for(int i=0; i<goodsList.size(); i++) {
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id)) {
				break;
			}
		}
		System.out.println("4");
		ArrayList<Book> list =(ArrayList<Book>) session.getAttribute("cartlist");
		if(list==null) {
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		System.out.println("5");
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
		System.out.println("6");
		if(cnt==0) {
			goods.setQuantity(1);
			list.add(goods);
		}
		
		resp.sendRedirect("products");
	}

}
