package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryAnalysedemo {

	@Test(retryAnalyzer = com.crm.comcast.genericUtility.RetryAnalayserImplementation.class)
	public void sample()
	{
		System.out.println("hello");
		Assert.fail();
	}
}
