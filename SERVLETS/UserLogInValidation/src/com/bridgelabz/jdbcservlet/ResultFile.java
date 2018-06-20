package com.bridgelabz.jdbcservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultFile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (String) req.getAttribute("name1");
		PrintWriter out = resp.getWriter();
		RequestDispatcher dispature = null;
		out.println("Welcome "+name+" in mumbai !");
		out.flush();
		out.close();
	}

}
