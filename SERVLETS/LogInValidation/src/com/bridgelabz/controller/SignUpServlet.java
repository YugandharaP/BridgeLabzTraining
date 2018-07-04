package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DataAccessObject;
import com.bridgelabz.model.UserBean;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 917826855031812665L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession(true);
		session.setMaxInactiveInterval(60);
		UserBean bean = new UserBean();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		bean.setMobile(mobile);
		String email = req.getParameter("email");
		bean.setEmail(email);
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String fullName = fname + " " + lname;
		bean.setFullName(fullName);
		if (password.equals(repassword)) {
			bean.setPassword(password);
			DataAccessObject object = new DataAccessObject();
			object.connectionPoolFactory();
			String insert = "insert into Students(FullName ,Mobile,Email,Password) values(?,?,?,?)";
			try {
				object.pst = object.con.prepareStatement(insert);
				object.pst.setString(1, fullName);
				object.pst.setLong(2, mobile);
				object.pst.setString(3, email);
				object.pst.setString(4, password);
				// session.setAttribute("msg", "hello moto");
				// System.out.println(session.getAttribute("msg"));
				object.pst.executeUpdate();

				session.setAttribute("message", "Hii " + fullName + " You are successfully register");
				resp.sendRedirect("SuccessfullRegister");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Password Not Matched!");
			resp.sendRedirect("passwordNotMatched");
		}

	}
}
