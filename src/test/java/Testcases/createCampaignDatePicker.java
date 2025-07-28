package Testcases;

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
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
	    String datereq = sim.format(cal.getTime());
		
        javautilities jutil=new javautilities();
        
		
		//create campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campname+jutil.getRandomNumber());
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys(size);
		WebElement closedate = driver.findElement(By.name("expectedCloseDate"));
		Actions act1=new Actions(driver);
		act1.click(closedate).sendKeys(datereq).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new 	WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
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
		//Actions act=new Actions(driver);
		//act.moveToElement(icon).perform();
		webutil.mouseHoveronWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		//act.moveToElement(logout).click().perform();
		webutil.clickonWebElement(driver, logout);

		}
	}


