package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class exam12_3_filter implements Filter {

	PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter03 초기화");
	
		String filename = filterConfig.getInitParameter("filename");
		System.out.println("filename : "+filename);
		
		
		if(filename==null) {
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		
		
		
		try {
			FileWriter fw = new FileWriter(filename, true);
			writer = new PrintWriter(fw, true);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		writer.printf("현재일시 : %s %n", getCurrentTime());
		
		String clientAddr = req.getRemoteAddr();
		System.out.println(clientAddr);
		writer.printf("클라이언트 주소 : %s %n", clientAddr);
		
		chain.doFilter(req, resp);
		
		String contentType = resp.getContentType();
		writer.printf("문서의 콘텐츠 유형 : %s %n", contentType);
		writer.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}



	@Override
	public void destroy() {
		writer.close();
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
