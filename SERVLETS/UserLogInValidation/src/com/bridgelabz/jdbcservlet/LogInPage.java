package com.bridgelabz.jdbcservlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInPage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3152161205091861114L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("pw");
		req.setAttribute("name1", name);
		RequestDispatcher dispature=req.getRequestDispatcher("result");
		dispature.forward(req, resp);
	}
}
