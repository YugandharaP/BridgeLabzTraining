package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		String sql="select * from Employee";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			stmt=con.createStatement();
			res=stmt.executeQuery(sql);
			while(res.next())
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				String salary=res.getString(3);
				String designation=res.getString(4);
				System.out.println(id+", "+name+", "+salary+" , "+designation);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null || stmt!=null || con!=null)
			{
				try {
					res.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}


