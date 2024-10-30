package Book_Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Create_Controller�� doGet() ����");
		//��ó��x
		
		//�� �̵�x
		
		//�� �̵�
		RequestDispatcher ds = req.getRequestDispatcher("addBook.jsp");
		ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Create_Controller�� doPost() ����");
		//��ó��
		req.setCharacterEncoding("UTF-8");
		String realFolder = req.getServletContext().getRealPath("resources/img");
		//�Ϲ� �ؽ�Ʈ�� �̹��� �����Ͱ� ���� �ֱ� ������ �и��ϱ� ����
		System.out.println("�̹��� ���� ���� ��� : "+realFolder);
		MultipartRequest multi = new MultipartRequest(req, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		if(multi==null) {
			System.out.println("MultipartRequest�� �ּҸ� �� ����");
		}
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String condition = multi.getParameter("condition");
		//�Ʒ� �ΰ��� ���� ������ ���ϹǷ� ������ ��ȯ�Ǿ���
		String unitPrice = multi.getParameter("unitPrice");
		String unitInStock = multi.getParameter("unitInStock");
		
		Integer price;
		
		if(unitPrice.isEmpty()) {
			price=0;
		} else {
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitInStock.isEmpty()) {
			stock=0;
		} else {
			stock = Long.valueOf(unitInStock);
		}
		//��������� �Ϲ� �ؽ�Ʈ ��ó��
		//����� �̹����� �̸��� ������ ����
		String file = multi.getFilesystemName("bookFile");
		System.out.println(file);
		
		//dto�� �Ϲ� �ؽ�Ʈ set
		Book bk = new Book();
		
		bk.setBookId(bookId);
		bk.setBookname(name);
		bk.setAuthor(author);
		bk.setPublisher(publisher);
		bk.setReleaseDate(releaseDate);
		bk.setBookdescription(description);
		bk.setBookcondition(condition);
		bk.setCategory(category);
		
		bk.setUnitPrice(price);
		bk.setUnitsInStock(stock);
		
		bk.setFilename(file);
		
		//�� �̵�
		BookRepository br = BookRepository.getInstance();
		br.addBook(bk);
		
		//�� �̵� : CUD�� ������ �� ����
		resp.sendRedirect("products");
		
	}

}
