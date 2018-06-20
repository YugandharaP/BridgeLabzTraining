package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class SavePointInTransaction {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pst = null;
		//PreparedStatement pst1 = null;
		Savepoint save = null;

		String insert1 = "insert into student values(?,?,?,?)";
		String update = "update student set branch=? where SID = ?";
		String delete= "delete from student where SID=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails?user=root&password=root");
			con.setAutoCommit(false);
			
			pst = con.prepareStatement(insert1);
			pst.setInt(1, 118);
			pst.setString(2, "divya");
			pst.setString(3, "Civil");
			pst.setInt(4, 2013);
			pst.executeUpdate();
			save = con.setSavepoint();
			System.out.println("savepoint");

			pst = con.prepareStatement(update);
			pst.setString(1, "CS");
			pst.setInt(2, 112);
			pst.executeUpdate();
			save = con.setSavepoint();
			System.out.println("savepoint1");
			
			pst=con.prepareStatement(delete);
			pst.setInt(1, 104);
			pst.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				System.out.println("you want to rollback: yes[0]/no[1]");
				int option = scn.nextInt();
				if (option == 0) {
					con.rollback(save);
				}
				con.commit();
				System.out.println("commited");
			} catch (SQLException e1) {
				System.out.println("opeartion is Rollbacked ");
			}
		} finally {
			if (pst != null || con != null) {
				try {
					pst.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Costly resourses not closed properly");
				}
			}
		}
	}
}
