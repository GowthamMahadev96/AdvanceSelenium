package TestcasesTestNG;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;

public class createCampaignDatePickerTest extends BaseClass {
	
	@Test(groups="regression")
	public  void createCampaignDatePicker() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility webutil=new WebDriverUtility();
		javautilities jutil=new javautilities();	
	    
		//Excel file 
	    String Campname = eutil.getDataFromExcel("Campaign", 1, 3);
	    String size = eutil.getDataFromExcel("Campaign", 1, 4);
	  //  String date = eutil.getDataFromExcel("Campaign", 1, 6);
	    int ran = jutil.getRandomNumber();
	    String expecteddate = jutil.togetRequired(30);
	    	
       //create campaign
        HomePage hp=new HomePage(driver);
        hp.getCreatecampaign().click();
	
        CampaignPage cp=new CampaignPage(driver);
        cp.getCampaignname().sendKeys(Campname);
		cp.getTargetsize().sendKeys(size);
			
		webutil.passinput(driver, cp.getClosedate(), jutil.togetRequired(30));
		
		cp.getCreateBTN().click();
		
		//validation
		Thread.sleep(5000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		webutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		
		Assert.assertEquals(msg, "Campaign "+Campname+"Sucessfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
}
	}


