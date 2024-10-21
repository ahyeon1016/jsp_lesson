package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class exam12_1_filter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter01 초기화...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter01.jsp 수행");
		String name = request.getParameter("name");
		
		if(name==null || name.equals("")) {
			System.out.println("입력값 공백!");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String message="입력된 name 값은 null 입니다.";
			writer.println(message);
			return;
		}
		System.out.println("입력값 문제 없음");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Filter01 해제...");
	}
	
}
