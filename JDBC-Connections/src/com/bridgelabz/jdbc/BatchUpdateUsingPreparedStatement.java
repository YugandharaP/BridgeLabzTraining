package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		
		String insert1 = "insert into student values(?,?,?,?)";
		String update = "update student set Branch = ? where SID=?";
		String delete = "delete from student where SID=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails?user=root&password=root");
			pst = con.prepareStatement(insert1);
			pst.setInt(1, 109);
			pst.setString(2, "Saurav");
			pst.setString(3, "Bsc");
			pst.setInt(4, 2018);
			pst.addBatch();
			pst.executeBatch();
			System.out.println("data inserted successfully");
			pst1 = con.prepareStatement(insert1);
			pst1.setInt(1, 104);
			pst1.setString(2, "Mamta");
			pst1.setString(3, "Agriculture");
			pst1.setInt(4, 2013);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("data inserted successfully");
			
			pst1 = con.prepareStatement(update);
			pst1.setString(1, "Agriculture");
			pst1.setInt(2, 105);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("updated successfully");
			
			pst = con.prepareStatement(delete);
			pst.setInt(1, 101);
			pst1.addBatch();
			pst1.executeBatch();
			System.out.println("Deleted successfully");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Data allready exist");
		} finally {
			if (pst != null || pst1 != null || con != null) {
				try {
					pst.close();
					pst1.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Costluy resourses not closed properly");
				}
			}
		}
	}
}
