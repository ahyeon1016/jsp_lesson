package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_1")
public class exam07_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter7/exam7_1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		MultipartRequest multi = new MultipartRequest(req, "C:\\upload", 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		Enumeration params = multi.getParameterNames();
		
		while(params.hasMoreElements()) {
			String name = (String)params.nextElement();
			String value = multi.getParameter(name);
			System.out.println(name+"="+value);
		}
		System.out.println("--------------------------------------------");
		
		Enumeration files= multi.getFileNames();
		File file;
		String filename;
		String type;
		
		while(files.hasMoreElements()) {
			String name = (String)files.nextElement();
			filename = multi.getFilesystemName(name);
			String original=multi.getOriginalFileName(name);
			type = multi.getContentType(name);
			file = multi.getFile(name);
			
			System.out.println("요청 파라미터 이름 : " + name);
			System.out.println("실제 파일 이름 : " + original);
			System.out.println("저장 파일 이름 : " + filename);
			System.out.println("파일 콘텐츠 유형 : " + type);
			
			if(file!=null) {
				System.out.println("파일 크기 : " + file.length());
			}
			req.setAttribute("file", file);
			req.setAttribute("filename", filename);
			req.setAttribute("type", type);
		}
		
		
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter7/exam7_1_page.jsp");
		ds.forward(req, resp);
		
		
	}
	
}
