package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class member_controller2 extends HttpServlet {
// 목표 : READ 여러개의 dto를 읽어와서 뷰에 출력하는 것이 목표
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("readall get도착");
		//전처리 : 파라미터 없음 생략
		//모델이동
		member_repository mr = member_repository.getInstance();
		ArrayList<member_dto> arr = mr.getAllmember();
		//뷰이동
		req.setAttribute("list", arr);
		RequestDispatcher ds = req.getRequestDispatcher("all.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
