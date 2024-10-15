package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_4")
public class exam07_4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 도착");
		
		RequestDispatcher ds =req.getRequestDispatcher("chapter7/exam7_4.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 도착");
		
		String save = req.getServletContext().getRealPath("img");
		String path = save;
		System.out.println("경로 : " + path);
		
		try {
			DiskFileUpload upload = new DiskFileUpload();
			
			upload.setSizeMax(1000000);
			upload.setSizeThreshold(4096);
			upload.setRepositoryPath(path);
			
			List items = upload.parseRequest(req);
			Iterator params = items.iterator();
			
			ArrayList<String> name_arr = new ArrayList<String>();
			ArrayList<String> file_arr = new ArrayList<String>();

			while(params.hasNext()) {
				FileItem item =(FileItem) params.next();
				
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println("name : " + name);
					System.out.println("value : " + value);
					name_arr.add(value);
					System.out.println(name_arr);
				} else {
					String fileFielName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					long fileSize=item.getSize();
					
					File file = new File(path + "/" + fileName);
					item.write(file);
					
					System.out.println("-------------");
					System.out.println("요청 파라미터 이름 : "+fileFielName);
					System.out.println("저장 파일 이름 : "+fileName);
					System.out.println("파일 콘텐츠 유형 : "+contentType);
					System.out.println("파일 크기 : "+fileSize); 
					
					file_arr.add(fileFielName);
					file_arr.add(fileName);
					file_arr.add(contentType);
					System.out.println(file_arr);
				}
			}
			
			System.out.println("밖 : "+name_arr);
			System.out.println("밖 : "+file_arr);
			req.setAttribute("name", name_arr);
			req.setAttribute("file", file_arr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		RequestDispatcher ds =req.getRequestDispatcher("chapter7/exam7_4_view.jsp");
		ds.forward(req, resp);
	}

}
