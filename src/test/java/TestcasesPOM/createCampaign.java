package TestcasesPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;

public class createCampaign {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
	PropertiesFileUtility putil=new PropertiesFileUtility();
	String BROWSER = putil.getdatafrompropertiesfile("Browser");
	String URL = putil.getdatafrompropertiesfile("URL");
	String USERNAME = putil.getdatafrompropertiesfile("Username");
	String PASSWORD = putil.getdatafrompropertiesfile("Password");
		
    ExcelFileUtility eutil=new ExcelFileUtility();
    String Campname = eutil.getDataFromExcel("Campaign", 1, 3);
    String size = eutil.getDataFromExcel("Campaign", 1, 4);
	
	WebDriverUtility webutil=new WebDriverUtility();
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	webutil.waitForPageToLoad(driver);
	
	
	//login to NINZA CRM
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.getUN().sendKeys(USERNAME);;
	lp.getPW().sendKeys(PASSWORD);
	lp.getLoginBTN().click();

	//create campaign
	javautilities jutil=new javautilities();
	HomePage hp=new HomePage(driver);
	hp.getCreatecampaign().click();
	
	CampaignPage cp=new CampaignPage(driver);
	cp.getCampaignname().sendKeys(Campname+jutil.getRandomNumber());
	cp.getTargetsize().sendKeys(size);
	cp.getCreateBTN().click();
	

	//validation
	
	WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
	webutil.waitforVisibilityofElement(driver, toast);
	String msg = toast.getText();
	
	if(msg.contains(Campname))
	{
		System.out.println("Campaign is created");
	}
	else
	{
		System.out.println("campaign not created");
	}
   hp.getToastCloseBTN().click();
	
	//logout
	Thread.sleep(2000);
	WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
	webutil.mouseHoveronWebElement(driver, icon);
	Thread.sleep(2000);
	hp.getLogoutBTN().click();
	driver.close();

	}

}
