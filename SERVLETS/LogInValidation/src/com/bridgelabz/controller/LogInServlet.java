package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DataAccessObject;

/**
 * @author yuga
 *
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = -7696017094585463102L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccessObject object = new DataAccessObject();
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String select = "select * from Students where Email = ? and Password = ?";
		System.out.println("second table : " + select);
		// connection create
		object.connectionPoolFactory();
		try {
			object.pst = object.con.prepareStatement(select);
			object.pst.setString(1, username);
			object.pst.setString(2, password);
			object.res = object.pst.executeQuery();
			System.out.println("res1" + object.res);
			if (object.res.next()) {
				/*
				 * req.setAttribute("serialNum", object.res.getInt("SerialNum"));
				 * req.setAttribute("fullName", object.res.getString("FullName"));
				 * req.setAttribute("mobile", object.res.getLong("Mobile"));
				 * req.setAttribute("username", username); req.setAttribute("password",
				 * password); System.out.println("set attributes");
				 */
				String fullName = object.res.getString(2);
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);

				Cookie cookie = new Cookie("fullName", fullName);
				cookie.setMaxAge(60 * 60 * 24);
				resp.addCookie(cookie);
				System.out.println("getting the cookie response");
				resp.sendRedirect("Display.jsp");
				System.out.println("after dispature servlet");

			} else {
				System.out.println("Not Valid user");

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
