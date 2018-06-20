package com.bridgelabz.jdbcservlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ServletUsingConnectionPool extends HttpServlet {

	private DataSource datasource;

	public void init(ServletConfig config) throws ServletException {
		try {
			// Look up the JNDI data source only once at init time
			Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
			datasource = (DataSource) envCtx.lookup("jdbc/MyDataSource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		Connection connection = null;
		try {
			Class.forName("com.jdbc.mysql.Driver");
			connection = getConnection();
			
		} catch (SQLException | ClassNotFoundException sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
	}
}
