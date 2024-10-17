
package chapter09;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/9_1")
public class exam09_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get도착");
		
		Locale locale = req.getLocale();
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		
		System.out.println("locale : "+locale);
		System.out.println("currentDate : "+currentDate);
		System.out.println("dateFormat : "+dateFormat);
		System.out.println("numberFormat : "+numberFormat);
		
		req.setAttribute("locale", locale);
		req.setAttribute("currentDate", currentDate);
		req.setAttribute("dateFormat", dateFormat);
		req.setAttribute("numberFormat", numberFormat);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter9/exam9_1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
