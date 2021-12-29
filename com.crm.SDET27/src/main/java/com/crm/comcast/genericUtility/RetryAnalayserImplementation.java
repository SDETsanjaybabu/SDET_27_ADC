package com.crm.comcast.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provide implementation for retryAnalyser
 * @author SanjayBabu
 *
 */
public class RetryAnalayserImplementation implements IRetryAnalyzer{

	int count =0;
	
	int retrycount =5;
	
	public boolean retry(ITestResult result) {
	while(count<=retrycount)
	{
		count++;
		return true;
	}
		return false;
	}

	
}
