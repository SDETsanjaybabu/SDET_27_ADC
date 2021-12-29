package com.crm.comcast.genericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DataBaseUtility {

	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("database connection successful");
	}
	
	@AfterSuite
	public void closeOfDB()
	{
		System.out.println("database connection closed");
	}
}
