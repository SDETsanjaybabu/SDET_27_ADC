package com.SEDT_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Rmg_SEDT_1 {

	public static void main(String[] args) throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		String expectedprojectname="laraclassied";
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8085");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//input[@name='projectName']"));
		ele1.sendKeys("laraclassied");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("babu");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel=new Select(ele);
		sel.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		List<WebElement> tabledata = driver.findElements(By.xpath("//td[2]"));
		int count=0;
		for(WebElement columndata:tabledata)
		{
			String Actualresult= columndata.getText();
			if(Actualresult.equals(expectedprojectname))
			{count++;}
		}
		if(count==1)
		{
			System.out.println("Front End Data is visible==>> TC PASS");
		}
		else
		{
			System.out.println("Front End Data is not visible==>> TC FAIL");
		}
		Connection connection=null;
	   try {
		   driver.quit();
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from project where project_name='laraclassified';");
			
			int back_count=0;
			while(result.next())
			{
				if(result.getString(4).equals(expectedprojectname))
				{
					back_count++;
				}
			}
			if (back_count==1)
			{
				System.out.println("Back End Data is visible==>> TC PASS");
			}
			else
			{
				System.out.println("Back End Data is not visible==>> TC FAIL");
			}
	   }catch (Exception e) 
			{
				// TODO: handle exception
			}finally {
				connection.close();
			}
	   }
}