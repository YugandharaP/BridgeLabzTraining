package com.bridgelabz.serviceimplementation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yuga
 *
 */
public class LogInPage extends HttpServlet {
	private static final long serialVersionUID = -7696017094585463102L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccessObject object = new DataAccessObject();
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String select = "select * from Students where Email = '" + username + "' and Password = '" + password + "'";
		System.out.println("second table : " + select);
		// connection create
		object.connectionPoolFactory();
		try {
			object.pst = object.con.prepareStatement(select);
			object.res = object.pst.executeQuery();
			System.out.println("res1" + object.res);
			if (object.res.next()) {
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				System.out.println("set attributes");
				RequestDispatcher dispature = req.getRequestDispatcher("Result.jsp");
				System.out.println("after dispature servlet");
				dispature.include(req, resp);
			} else {
				System.out.println("Not Valid user");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
