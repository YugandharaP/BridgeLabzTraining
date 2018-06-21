package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogInValidation {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from logindb.validation v,logindb.admin a where v.username=a.username and a.username=? and a.password=?";
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = scn.next();
		System.out.println("Enter password: ");
		String pwd = scn.next();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			if (rs.next()) {
				String name = rs.getString(1);
				long mobile = rs.getLong(2);
				String branch = rs.getString(3);
				System.out.println("Welcome " + name);
				System.out.println("your details are here :\nName: " + name + " MobileNumber : " + mobile + " Branch : "
						+ branch + " | " + username);
			} else {
				System.out.println("Invalid username and password !");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}
}
