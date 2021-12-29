package com.SEDT_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Rmg_Verify {

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			Connection con=null;
			
			try
			{
				String expectedname="suraj";
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root"); 
				Statement statement = con.createStatement();
				int result = statement.executeUpdate("insert into project values('TY_PROJ_1207','1suraj','16/12/2021','1laraclassified','created','0');");
				ResultSet accresult = statement.executeQuery("select * from project");
				while(accresult.next())
				{
					
					if(accresult.getString(2).equalsIgnoreCase(expectedname))
					{
						System.out.println("passed");
					}
					else
					{
						System.out.println("failed");
					}

				}

			}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				con.close();
			}
	}

}