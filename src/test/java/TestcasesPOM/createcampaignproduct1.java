package TestcasesPOM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;

public class createcampaignproduct1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertiesFileUtility putil=new PropertiesFileUtility();
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
	 
	 ExcelFileUtility Eutil=new ExcelFileUtility();
	 String Productname = Eutil.getDataFromExcel("Product", 1, 2);
	 String Quantity = Eutil.getDataFromExcel("Product", 1, 3);
	 String Price = Eutil.getDataFromExcel("Product", 1, 4);
	
	 WebDriverUtility Wutil=new WebDriverUtility();
	 WebDriver driver=new EdgeDriver();
	 driver.get(URL);
	 driver.manage().window().maximize();
	 Wutil.waitForPageToLoad(driver);
	 
	//Login to Ninza
	 LoginPage lp=new LoginPage(driver);
	 lp.getUN().sendKeys(USERNAME);
	 lp.getPW().sendKeys(PASSWORD);
	 lp.getLoginBTN().click();
	 
	 //Add Product
	 HomePage hp=new HomePage(driver);
	 hp.getProducts().click();
	 
	 hp.getAddProductBTN().click();
	 
	 AddProduct ap=new AddProduct(driver);
	 javautilities Jutil=new javautilities();
	 
	 ap.getProductname().sendKeys(Productname+Jutil.getRandomNumber());
	 
	 //Dropdown1
	 ap.getProductcategory().sendKeys("Furniture");
	
	 ap.getQuantity().sendKeys(Quantity);
	 
     ap.getPrice().sendKeys(Price);
	//DropDown2
	 ap.getVendorid().sendKeys("VID_001");
	 
	 ap.getAddBTN().click();
	 
	//validation
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Wutil.waitforVisibilityofElement(driver, toast);
	    String msg = toast.getText();
		
		if(msg.contains(Productname))
		{
			System.out.println("Product successfully Added");
		}
		else
		{
			System.out.println("Product not Added");
		}

		hp.getToastCloseBTN().click();
		
		//logout
		WebElement icon=driver.findElement(By.xpath("//div[@class='user-icon']"));
	    Wutil.mouseHoveronWebElement(driver, icon);
		hp.getLogoutBTN().click();
		driver.close();
		
	}

}
