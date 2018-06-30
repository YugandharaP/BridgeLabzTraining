package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.DataAccessObject;

@SuppressWarnings("serial")
public class DisplayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		int serialNum = (int) req.getAttribute("serialNum");
		String fullName = (String) req.getAttribute("fullName");
		String mobile = (String) req.getAttribute("mobile");
		String username = (String) req.getAttribute("username");
		DataAccessObject object = new DataAccessObject();
		object.connectionPoolFactory();
		req.setAttribute("serialNo", serialNum);
		req.setAttribute("fullName", fullName);
		req.setAttribute("mobile", mobile);
		req.setAttribute("email", username);
		try {
			resp.sendRedirect("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
