package Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
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
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		Wutil.waitForPageToLoad(driver);
		
		//login to NINZA CRM
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		//create campaign
		javautilities jutil=new javautilities();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campname+jutil.getRandomNumber());
		driver.findElement(By.name("campaignStatus")).sendKeys(Status);
		//driver.findElement(By.name("targetAudience")).sendKeys("america");
		WebElement TargetName = driver.findElement(By.name("targetSize"));
		TargetName.clear();
		TargetName.sendKeys(Size);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Wutil.waitforVisibilityofElement(driver, toast);
		//WebDriverWait wait=new 	WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toast));
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
		//Actions act=new Actions(driver);
		//act.moveToElement(icon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		//act.moveToElement(logout).click().perform();
		Wutil.clickonWebElement(driver, logout);
		}
		
	}


