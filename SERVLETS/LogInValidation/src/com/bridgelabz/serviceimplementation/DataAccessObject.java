package com.bridgelabz.serviceimplementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataAccessObject {
	static final String FILEPATH="/home/adminsitrator/Documents/Program/LogInValidation/src/com/bridgelabz/files/DBDetails.properties";
	Connection con =null;
	Statement stmt= null;
	DataSource datasource = null;
	

public static DataSource getMySQLDataSource() {
	Properties props =new Properties();
	FileInputStream file = null;
	//only for mysql database
	MysqlDataSource mysqlDS =null;
	try {
		FileInputStream fileRead= new FileInputStream(FILEPATH);
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

/*DataSource ds=null;
ds=DataSourceFactory.getMySQLDataSource();
Connection con=null;
Statement st= null;
String query="insert into capgenimi.employees values(120,'Rahul','Manager')";
try {
	con=ds.getConnection();
	st=con.createStatement();
	st.executeUpdate(query);
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally {
	if(st!=null)
	{
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(con!=null)
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream file = null;
		MysqlDataSource mysqlDS = null;
		try {
			file = new FileInputStream("/home/bridgelabz/saurav/JDBCPractice/src/com/bridgelabz/db.properties");
			props.load(file);
			mysqlDS = new MysqlDataSource();
			mysqlDS.getURL();
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}
*/