package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardListController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.print("�ȳ��ϼ���!");
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}
}
