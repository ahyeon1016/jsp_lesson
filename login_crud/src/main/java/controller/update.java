package controller;

import java.io.IOException;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/update get µµÂø");
		//ÀüÃ³¸®
		String id = req.getParameter("id");
		System.out.println(id);
		//¸ðµ¨ ÀÌµ¿
		member_repository mr = member_repository.getInstance();
		member_dto dto = mr.getOnemember(id);
		//ºä ÀÌµ¿
		req.setAttribute("DTO", dto);
		RequestDispatcher ds = req.getRequestDispatcher("updateform.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/update post µµÂø");
		//ÀüÃ³¸®
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(age);
		
		member_dto dto = new member_dto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setAge(age);
		//¸ðµ¨ ÀÌµ¿
		member_repository mr = member_repository.getInstance();
		mr.update_member(dto);
		//ºä ÀÌµ¿
		resp.sendRedirect("readall");
	}

}
