package TestcasesTestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class createCampaignTest extends BaseClass{

	@Test(groups="smoke")
	public void createCampaign() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility webutil=new WebDriverUtility();
	javautilities jutil=new javautilities();
	
	//Read Data from Excel
    String Campname = eutil.getDataFromExcel("Campaign", 1, 3);
    String size = eutil.getDataFromExcel("Campaign", 1, 4);
  
    
	
	//create campaign
	
	HomePage hp=new HomePage(driver);
	hp.getCreatecampaign().click();
	
	CampaignPage cp=new CampaignPage(driver);
	cp.getCampaignname().sendKeys(Campname);
	cp.getTargetsize().sendKeys(size);
	cp.getCreateBTN().click();
	

	//validation
	Thread.sleep(5000);
    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
	//Thread.sleep(5000);
	webutil.waitforVisibilityofElement(driver, toast);
	String msg = toast.getText();
	
	Assert.assertEquals(msg, "Campaign "+Campname+"Sucessfully Added");
	hp.getToastCloseBTN().click();
}

}
