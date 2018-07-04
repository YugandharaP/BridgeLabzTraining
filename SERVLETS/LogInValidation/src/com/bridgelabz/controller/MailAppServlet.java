package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MailAppServlet extends HttpServlet {
	private static final long serialVersionUID = -4107894134507906062L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		final String email = req.getParameter("email");
		final String adminEmail = "dharaparanjape.1007@gmail.com";
		String password = "dhara1007";
		SendMail.send(email, adminEmail, password);
		HttpSession session= req.getSession();
		session.setAttribute("sendMessage", "Message SuccessFully Sent !");
		resp.sendRedirect("SendMail.jsp");
		System.out.println("send email successfully");
	}
}
