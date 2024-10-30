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

@WebServlet("/updateBook")
public class Update_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Update_Controller doGet() 도착]");
		//전처리
		String bookId = req.getParameter("id");
		System.out.println("bookId : "+bookId);
		//모델이동
		BookRepository br = BookRepository.getInstance();
		Book dto = br.getBookById(bookId);
		if(dto==null) {
			System.out.println("dto에 값이 없음 Repository 확인해 볼것");
		}
		//뷰이동
		req.setAttribute("dto", dto);
		RequestDispatcher ds = req.getRequestDispatcher("updateBook.jsp");
		ds.forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[[Update_Controller doPost() 도착]");
		//전처리
		req.setCharacterEncoding("UTF-8");
		String realFolder = req.getServletContext().getRealPath("resources/img");
		//일반 텍스트와 이미지 데이터가 섞여 있기 때문에 분리하기 위함
		System.out.println("이미지 파일 저장 경로 : "+realFolder);
		MultipartRequest multi = new MultipartRequest(req, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		if(multi==null) {
			System.out.println("MultipartRequest의 주소를 못 받음");
		}
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String condition = multi.getParameter("condition");
		//아래 두개의 값은 갯수를 뜻하므로 정수로 변환되야함
		String unitPrice = multi.getParameter("unitPrice");
		String unitsInStock = multi.getParameter("unitsInStock");
		
		//유효성 검사
		Integer price;
		
		if(unitPrice.isEmpty()) {
			price=0;
		} else {
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitsInStock.isEmpty()) {
			stock=0;
		} else {
			stock = Long.valueOf(unitsInStock);
		}
		//여기까지가 일반 텍스트 전처리
		//저장된 이미지의 이름을 변수에 저장
		String file = multi.getFilesystemName("bookFile");
		System.out.println(file);
		
		//dto에 일반 텍스트 set
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
		
		//모델 이동
		BookRepository br = BookRepository.getInstance();
		br.updBook(bk);
		
		//뷰이동
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		resp.sendRedirect("products");
	}

}
