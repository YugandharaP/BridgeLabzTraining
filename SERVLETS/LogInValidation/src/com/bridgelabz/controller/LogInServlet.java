package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		
		object.connectionPoolFactory();
		try {
			System.out.println("enter into try");
			object.pst = object.con.prepareStatement(select);
			object.pst.setString(1, username);
			object.pst.setString(2, password);
			object.res = object.pst.executeQuery();
			System.out.println("res1" + object.res);
			if (object.res.next()) {
				HttpSession session = req.getSession(true);
				int serialNum = object.res.getInt(1);
				String fullName = object.res.getString(2);
				long mobile = object.res.getLong(3);
				session.setAttribute("message", "you are successfully login");
				session.setAttribute("serialNum", serialNum);
				session.setAttribute("fullName", fullName);
				session.setAttribute("mobile", mobile);
				session.setAttribute("username", username);
				resp.sendRedirect("SuccessFullLogIn");
				System.out.println("after dispature servlet");
			} else {
				System.out.println("Not Valid user");
				resp.sendRedirect("UnsuccessfulLogIn");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
