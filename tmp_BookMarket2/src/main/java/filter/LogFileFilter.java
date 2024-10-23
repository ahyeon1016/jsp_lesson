package filter;

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
import jakarta.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter {

	PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LogFileFilter �ʱ�ȭ");
		String filename=filterConfig.getInitParameter("filename");
		
		if(filename==null) {
			throw new ServletException("�α� ������ �̸��� ã�� �� �����ϴ�.");
		}
		try {
			FileWriter fw = new FileWriter(filename, true);
			writer = new PrintWriter(fw,true);
		} catch (IOException e) {
			throw new ServletException("�α� ������ �� �� �����ϴ�.");
		}
	}



	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		writer.println(" ������ Ŭ���̾�Ʈ IP : "+req.getRemoteAddr());
		long start = System.currentTimeMillis();
		writer.println(" ������ URL ��� : "+getURLPath(req));
		writer.println(" ��û ó�� ���� : "+getCurrentTime());
		chain.doFilter(req, resp);
		
		long end = System.currentTimeMillis();
		writer.println(" ��û ó�� ���� �ð� : "+getCurrentTime());
		writer.println(" ��û ó�� �ҿ� �ð� : "+(end-start)+"ms ");
		writer.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
	}
	
	@Override
	public void destroy() {
		writer.close();
	}

	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest)request;
			currentPath = req.getRequestURI();
			queryString = req.getQueryString();
			
			 
			queryString = queryString==null? "" : ""+queryString;
//			if(queryString==null){
//				queryString="";
//			} else {
//				queryString =""+queryString;
//			}

		}
		
		return currentPath+queryString;
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
