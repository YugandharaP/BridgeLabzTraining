package com.bridgelabz.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.DAO.DataAccessObject;

/**
 * Purpose: To Insert multiple records in the database via Callable Statement
 * @author Yuga
 * @version 1.0
 * @since 20/06/2018
 ***/
 
public class InsertDataUsingCallableStatement {

	public static void main(String[] args) {
		DataAccessObject object=new DataAccessObject();
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the id: ");
		int id= scan.nextInt();
		System.out.println("Enter the name:");
		String name=scan.next();
		System.out.println("Enter the branch:");
		String branch=scan.next();
		System.out.println("Enter the year of pass");
		int year=scan.nextInt();
		object.connectionPoolFactory();
		try {
		object.cst=object.con.prepareCall("call studentInsert(?,?,?,?)");
		object.cst.setInt(1, id);
		object.cst.setString(2, name);
		object.cst.setString(3, branch);
		object.cst.setInt(4, year);
		object.cst.executeUpdate();	
		System.out.println("Data Inserted Successfully Using Callable Statement ");
		} catch (Exception e) {
			System.out.println("Exception has occurred..");
			e.printStackTrace();
		}
		finally {
			if(object.cst!=null)
			{
				try {
					object.cst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(object.con!=null)
			{
				try {
					object.con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
