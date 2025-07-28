package Testcases;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssert 
{
	@Test
	public void demo()
	{
		String ExpectedTitle = "Facebook - Log in or sign up";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		@Nullable
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		Reporter.log("Step1");
		Reporter.log("Step2");
	}
	
}
