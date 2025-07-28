package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test(invocationCount=3)
	public void login() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		Reporter.log("execution done",true);
		Thread.sleep(3000);
	
	}}
	
