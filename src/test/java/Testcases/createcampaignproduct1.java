package Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;

public class createcampaignproduct1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	 PropertiesFileUtility Futil=new PropertiesFileUtility();
	 String BROWSER = Futil.getdatafrompropertiesfile("Browser");
	 String URL = Futil.getdatafrompropertiesfile("URL");
	 String USERNAME = Futil.getdatafrompropertiesfile("Username");
	 String PASSWORD = Futil.getdatafrompropertiesfile("Password");
	 
	 ExcelFileUtility Eutil=new ExcelFileUtility();
	 String Productname = Eutil.getDataFromExcel("Product", 1, 3);
	 String Quantity = Eutil.getDataFromExcel("Product", 1, 4);
	String Price = Eutil.getDataFromExcel("Product", 1, 5);
	
	 WebDriverUtility Wutil=new WebDriverUtility();
	 WebDriver driver=new FirefoxDriver();
	 driver.get(URL);
	 driver.manage().window().maximize();
	 Wutil.waitForPageToLoad(driver);
	 
	//Login to Ninza
	 driver.findElement(By.id("username")).sendKeys(USERNAME);
	 driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 
	 
	 //Add Product
	 driver.findElement(By.linkText("Products")).click();
	 driver.findElement(By.xpath("//span[text()='Add Product']")).click();
	 javautilities Jutil=new javautilities();
	 driver.findElement(By.name("productName")).sendKeys(Productname+Jutil.getRandomNumber());
	 
	 //Dropdown1
	 WebElement Categorydropdown = driver.findElement(By.name("productCategory"));
	 Wutil.select(Categorydropdown, "Furniture");
	 
	 WebElement quantity = driver.findElement(By.name("quantity"));
	 quantity.clear();
	 quantity.sendKeys(Quantity);
	 
	 
	 WebElement price = driver.findElement(By.name("price"));
	 price.clear();
	 price.sendKeys(Price);
	 
	 //DropDown2
	 WebElement vendordropdown = driver.findElement(By.name("vendorId"));
	 Wutil.select(vendordropdown, "VID_001");
	 
	 driver.findElement(By.xpath("//button[text()='Add']")).click();
	 
	//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new 	WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toast));
		String msg = toast.getText();
		
		if(msg.contains(Productname))
		{
			System.out.println("Product successfully Added");
		}
		else
		{
			System.out.println("Product not Added");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//logout
		WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(icon).perform();
		Wutil.mouseHoveronWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		//act.moveToElement(logout).click().perform();
		Wutil.clickonWebElement(driver, logout);

	
	
	
	
	
	
	
	
	
	
	}

}
