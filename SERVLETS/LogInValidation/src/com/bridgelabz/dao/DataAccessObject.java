package com.bridgelabz.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataAccessObject {
	static final String FILEPATH = "/home/adminsitrator/Documents/Program/LogInValidation/src/com/bridgelabz/files/DBDetails.properties";
	public Connection con = null;
	public Statement stmt = null;
	public PreparedStatement pst=null;
	public ResultSet res=null;
	
	DataSource datasource = null;
	/**
	 * To establish a connection using connection pool concept
	 */
	public void connectionPoolFactory() {
		datasource=getMySQLDataSource();
		try {
			con = datasource.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Connection issue occured");
		}
	}
	
	/**
	 * To closed costly connection
	 */
	public void closeCostlyConnections() {
			if (stmt != null || con != null||pst!=null) {
				try {
					pst.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Costly resourses not close properly");
				}
			}
	}

	/**To fetch user name,password ,url of specific database
	 * @return mysql datasource object
	 */
	public  DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream file = null;
		// only for mysql database
		MysqlDataSource mysqlDS = null;
		try {
			FileInputStream fileRead = new FileInputStream(FILEPATH);
			props.load(fileRead);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("URL"));
			mysqlDS.setUser(props.getProperty("USER"));
			mysqlDS.setPassword(props.getProperty("PASSWORD"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}
}
