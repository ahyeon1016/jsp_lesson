package controller;

import java.io.IOException;

import dao.member_repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		System.out.println(id);
		
		//∏µ®¿Ãµø
		member_repository mr = member_repository.getInstance();
		mr.deleteUser(id);
		//∫‰¿Ãµø
		resp.sendRedirect("readall");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
