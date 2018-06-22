package com.bridgelabz.jdbc;

import java.sql.SQLException;
import com.bridgelabz.DAO.DataAccessObject;
/**
 * Purpose: To Display multiple records from the database via Callable Statement
 * @author Yuga
 * @version 1.0
 * @since 20/06/2018
 ***/
 

public class DisplayDetailsUsingCallableStatement {

	public static void main(String[] args) {
		DataAccessObject object=new DataAccessObject();
		object.connectionPoolFactory();
		try {
		object.cst=object.con.prepareCall(" call studentSelect()");
		object.res=object.cst.executeQuery();
		while(object.res.next())
		{
			int id = object.res.getInt(1);
			String name= object.res.getString(2);
			String branch =object.res.getString(3);
			int year = object.res.getInt(4);
			System.out.println("Id : "+id+" Name :"+name+" Branch : "+branch+"  YearOfPass : "+year);
		}
		
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
