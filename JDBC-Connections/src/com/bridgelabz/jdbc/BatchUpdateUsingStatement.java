package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateUsingStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String insert1 = "insert into student values(101,'Yuga','ComputerScience',2017)";
		String insert2 = "insert into student values(102,'Sweta','ComputerScience',2016)";
		String insert3 = "insert into student values(103,'Vishal','Civil',2015)";
		String insert4 = "insert into student values(104,'Bijaya','EXTC',2017)";
		String update = "update student set Branch = 'Mechanical' where SID=102";
		String delete = "delete from student where SID=104";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails?user=root&password=root");
			stmt = con.createStatement();
			stmt.addBatch(insert1);
			stmt.addBatch(insert2);
			stmt.addBatch(insert3);
			stmt.addBatch(insert4);
			stmt.addBatch(update);
			stmt.addBatch(delete);
			int[] array = stmt.executeBatch();
			System.out.println(" Operations are done : " + array.length);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Data allready exist");
		} finally {
			if (stmt != null || con != null) {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
