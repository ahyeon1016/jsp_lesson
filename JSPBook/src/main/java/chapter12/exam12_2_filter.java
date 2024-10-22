package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class exam12_2_filter implements Filter {
	
	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 초기화...");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter02 수행...");
		
		String id_f = request.getParameter("id");
		String pwd_f = request.getParameter("pwd");
		
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		System.out.println("if문 시작");
		if(id_f.equals(param1) && pwd_f.equals(param2)) {
			System.out.println("true");
			message = "로그인에 성공했습니다.";
		} else {
			System.out.println("false");
			message = "로그인에 실패했습니다";
		}
		System.out.println("if문 끝");
		System.out.println(message);
		
		writer.println(message+"<br>");
		writer.println("아이디 : "+id_f+"<br>	");
		writer.println("비밀번호: "+pwd_f);

		//chain.doFilter(request, response);
	}


	@Override
	public void destroy() {
		System.out.println("Filter02 해제...");
	}
}
