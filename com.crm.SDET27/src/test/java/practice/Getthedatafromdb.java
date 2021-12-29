package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Getthedatafromdb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connect.createStatement();
	
	}

}
