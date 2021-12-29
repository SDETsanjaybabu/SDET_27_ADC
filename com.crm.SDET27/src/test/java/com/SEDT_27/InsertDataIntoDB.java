package com.SEDT_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDB {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "root"); 
		Statement statement = connection.createStatement();
		String query = "insert into studentinfo values(6,'hi','hello','banglore')";
		int result = statement.executeUpdate(query);
		if(result == 1)
		{
			System.out.println("student created successfully");
		}else{
			System.out.println("student is crested");
		}
	}
}
