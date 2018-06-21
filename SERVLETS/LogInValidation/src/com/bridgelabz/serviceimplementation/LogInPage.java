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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PreparedStatement pst = null;
		DataAccessObject object = new DataAccessObject();
		String regNum = req.getParameter("username");
		String password = req.getParameter("password");
		long username = Long.parseLong(regNum);
		String select = "select * from Bridgelabz.employees emp ,  Bridgelabz.Admin admin where "
				+ "emp.RegisterNumber = admin.RegisterNumber and " + "admin.RegisterNumber =? and admin.Password =?";
		System.out.println("second table" + select);
		// connection create
		object.connectionPoolFactory();
		try {
			pst = object.con.prepareStatement(select);
			pst.setLong(1, username);
			pst.setString(2, password);
			object.res = pst.executeQuery();
			System.out.println("res1" + object.res);
			if (object.res.next()) {
				long regNo = object.res.getLong(1);
				String ename = object.res.getString(2);
				long mobile = object.res.getLong(3);
				long year = object.res.getLong(4);
				String designation = object.res.getString(5);
				long salary = object.res.getLong(6);
				System.out.println("getting value");
				RequestDispatcher dispature = req.getRequestDispatcher("Result.html");
				dispature.forward(req, resp);
			} else {
				System.out.println("Not Valid user");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
