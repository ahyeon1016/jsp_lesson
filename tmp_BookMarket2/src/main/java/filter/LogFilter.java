package filter;

import java.io.IOException;
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

public class LogFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("�� ���� �ʱ�ȭ");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(" ������ Ŭ���̾�Ʈ IP : "+req.getRemoteAddr());
		long start = System.currentTimeMillis();
		System.out.println(" ������ URL ��� : "+getURLPath(req));
		System.out.println(" ��û ó�� ���� : "+getCurrentTime());
		chain.doFilter(req, resp);
		
		long end = System.currentTimeMillis();
		System.out.println(" ��û ó�� ���� �ð� : "+getCurrentTime());
		System.out.println(" ��û ó�� �ҿ� �ð� : "+(end+start)+"ms ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
		
	}

	
	@Override
	public void destroy() {

	}
	
	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest)request;
			currentPath = req.getRequestURI();
			queryString = req.getQueryString();
			
			System.out.println("currentPath : "+currentPath+"/queryString : "+queryString);
			 
			queryString = queryString==null? "" : ""+queryString;
//			if(queryString==null){
//				queryString="";
//			} else {
//				queryString =""+queryString;
//			}
			System.out.println("currentPath : "+currentPath+"/queryString : "+queryString);

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