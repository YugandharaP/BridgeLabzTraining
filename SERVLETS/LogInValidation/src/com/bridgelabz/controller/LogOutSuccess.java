package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("enterd into logout page");
		HttpSession session = req.getSession();
		if (req.getParameter("LogOut") != null) {
			session.invalidate();
			RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
