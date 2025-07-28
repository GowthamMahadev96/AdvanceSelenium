package TestcasesPOM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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

public class createCampaignDatePicker {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertiesFileUtility putil=new PropertiesFileUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
			
	    ExcelFileUtility eutil=new ExcelFileUtility();
	    String Campname = eutil.getDataFromExcel("Campaign", 1, 3);
	    String size = eutil.getDataFromExcel("Campaign", 1, 4);
	  //  String date = eutil.getDataFromExcel("Campaign", 1, 6);
		
	    WebDriverUtility webutil=new WebDriverUtility();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		webutil.waitForPageToLoad(driver);
		
		//login to NINZA CRM
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBTN().click();

		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
	    String datereq = sim.format(cal.getTime());
		
        javautilities jutil=new javautilities();
        
		
		//create campaign
        HomePage hp=new HomePage(driver);
        hp.getCreatecampaign().click();
	
        CampaignPage cp=new CampaignPage(driver);
        cp.getCampaignname().sendKeys(Campname+jutil.getRandomNumber());
		cp.getTargetsize().sendKeys(size);
			
		webutil.passinput(driver, cp.getClosedate(), jutil.togetRequired(30));
		
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
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//logout
		WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		webutil.mouseHoveronWebElement(driver, icon);
		hp.getLogoutBTN().click();
		driver.close();

		}
	}


