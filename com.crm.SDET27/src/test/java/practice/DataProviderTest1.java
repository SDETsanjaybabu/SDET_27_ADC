package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
	@Test(dataProvider = "getData")
	public void  readDataFromDataProviderTest(String Name,int qty,String colour)
	{
		System.out.println("mobile name "+Name+" mobile qty "+qty+"mobile colour  "+colour);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[5][3];
		
		objArr[0][0]="Iphone";
		objArr[0][1]=10;
		objArr[0][2]="Black";
		
		objArr[1][0]="Samsung";
		objArr[1][1]=20;
		objArr[1][2]="White";
		
		objArr[2][0]="Vivo";
		objArr[2][1]=30;
		objArr[2][2]="Red";
		
		objArr[3][0]="Oppo";
		objArr[3][1]=40;
		objArr[3][2]="Yellow";
		
		objArr[4][0]="Nokia";
		objArr[4][1]=50;
		objArr[4][2]="Green";
		
		return objArr;
	}
}
