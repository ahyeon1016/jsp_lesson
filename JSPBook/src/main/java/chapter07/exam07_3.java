package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_3")
public class exam07_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter7/exam7_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");

		try {
			String save = req.getServletContext().getRealPath("img");
			String fileUploadPath = save;
			System.out.println(save);
			
			DiskFileUpload upload = new DiskFileUpload();
			List items = upload.parseRequest(req);
			Iterator params = items.iterator();
			System.out.println("param아래");
			while(params.hasNext()) {
				System.out.println("while문 진입");
				FileItem fileItem = (FileItem)params.next();
				System.out.println("파일아이템아래");
				if(!fileItem.isFormField()) {
					System.out.println("if문 진입");
					String fileName=fileItem.getName();
					System.out.println(fileName);
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					File file = new File(fileUploadPath+"/"+fileName);
					fileItem.write(file);
					System.out.println(fileName);
					System.out.println(file);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
