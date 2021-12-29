package com.SEDT_27;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataInDB {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String expectedstudentfirstname="hi";
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "root"); 
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from studentinfo");
		while(result.next())
		{
		if(result.getString(2).equals(expectedstudentfirstname))
		{
			System.out.println("passed");
		}
		}
		connection.close();
	}
}