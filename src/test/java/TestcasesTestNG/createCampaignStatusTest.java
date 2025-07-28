package TestcasesTestNG;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;
@Listeners(ListenerUtility.Listener.class)

public class createCampaignStatusTest extends BaseClass {

	@Test
	public  void  createCampaignStatus()  throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//From Properties Utilities
		PropertiesFileUtility putil=new PropertiesFileUtility();
		ExcelFileUtility Eutil=new ExcelFileUtility();
		WebDriverUtility Wutil=new WebDriverUtility();
		javautilities jutil=new javautilities();
		
		//From Excel Utilities
		String Campname = Eutil.getDataFromExcel("Campaign", 1, 3);
		String Size=Eutil.getDataFromExcel("Campaign", 1, 4);
		String Status=Eutil.getDataFromExcel("Campaign", 1, 5);
		int ran = jutil.getRandomNumber();
		
		
        //create campaign
		
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampaignname().sendKeys(Campname);
		cp.getCampaignstatus().sendKeys(Status);
		cp.getTargetsize().sendKeys(Size);
		cp.getCreateBTN().click();
		
		//validation
		Thread.sleep(5000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		
		Assert.assertEquals(msg, "Campaign "+Campname+"Sucessfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		

		
	}}


