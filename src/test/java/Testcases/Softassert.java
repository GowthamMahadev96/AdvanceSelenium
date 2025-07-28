package Testcases;

import javax.annotation.Nullable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert 
{
	@Test
	public void demo()
	{
		String ActualTitle = "Facebook - Log in or sign up";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	//	@Nullable
		String ExpectedTitle=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Step1");
		System.out.println("Step2");
		soft.assertAll();
		
	}
}
