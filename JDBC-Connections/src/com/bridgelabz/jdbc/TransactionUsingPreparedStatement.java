package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		// PreparedStatement pst1=null;
		String insert1 = "insert into student values(?,?,?,?)";
		String delete = "delete from student where SID = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails?user=root&password=root");
			con.setAutoCommit(false);
			pst = con.prepareStatement(insert1);
			pst.setInt(1, 122);
			pst.setString(2, "Simran");
			pst.setString(3, "Doctor");
			pst.setInt(4, 2010);
			pst.executeUpdate();
			System.out.println("Inserted successfully");
			pst = con.prepareStatement(delete);
			pst.setInt(1, 110);
			pst.executeUpdate();
			System.out.println("deleted successfully");
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
				System.out.println("opeartion is Rollbacked ");
			} catch (SQLException e1) {
				System.out.println("not successful");
			}

		} finally {
			if (pst != null || con != null) {
				try {
					pst.close();

					con.close();
				} catch (SQLException e) {
					System.out.println("Costluy resourses not closed properly");
				}
			}
		}
	}

}
