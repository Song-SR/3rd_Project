package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;


public class joinController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ctx = request.getContextPath();
		String result = null;
		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.sign(name, id, pw);
		if (cnt > 0) {
			System.out.println("회원가입 완료");
			result = "main.jsp";
		}else {
			System.out.println("회원가입 실패");
			result = "sign.jsp";
		}
		return result;
		
}}
