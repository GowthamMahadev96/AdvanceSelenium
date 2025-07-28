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

public class createCampaignStatus {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//From Properties Utilities
		PropertiesFileUtility putil=new PropertiesFileUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
		
		//From Excel Utilities
		ExcelFileUtility Eutil=new ExcelFileUtility();
		String Campname = Eutil.getDataFromExcel("Campaign", 1, 3);
		String Size=Eutil.getDataFromExcel("Campaign", 1, 4);
		String Status=Eutil.getDataFromExcel("Campaign", 1, 5);
		
		//From WebDriverUtility
		WebDriverUtility Wutil=new WebDriverUtility();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		Wutil.waitForPageToLoad(driver);
		
		//login to NINZA CRM
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBTN().click();
		
		//create campaign
		javautilities jutil=new javautilities();
		HomePage hp=new HomePage(driver);
		hp.getCreatecampaign().click();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampaignname().sendKeys(Campname+jutil.getRandomNumber());
		cp.getCampaignstatus().sendKeys(Status);
		cp.getTargetsize().sendKeys(Size);
		cp.getCreateBTN().click();
		
		//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Wutil.waitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		
		if(msg.contains(Campname))
		{
			System.out.println("Campaign is created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//logout
		WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		Wutil.mouseHoveronWebElement(driver, icon);

		 hp.getLogoutBTN().click();
		 driver.close();
		}
		
	}


