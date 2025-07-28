package TestcasesTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelFileUtility;
import JavaUtilities.javautilities;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;
@Listeners(ListenerUtility.Listener.class)

public class createcampaignproduct1Test extends BaseClass {

	@Test(groups="smoke")
	public  void createcampaignproduct1() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ExcelFileUtility Eutil=new ExcelFileUtility();
		WebDriverUtility Wutil=new WebDriverUtility();
		 javautilities Jutil=new javautilities();
	 
	 String Productname = Eutil.getDataFromExcel("Product", 1, 2);
	 String Quantity = Eutil.getDataFromExcel("Product", 1, 3);
	 String Price = Eutil.getDataFromExcel("Product", 1, 4);
	

	 //Add Product
	 HomePage hp=new HomePage(driver);
	 hp.getProducts().click();
	 
	 hp.getAddProductBTN().click();
	 
	 AddProduct ap=new AddProduct(driver);
	
	 
	 ap.getProductname().sendKeys(Productname+Jutil.getRandomNumber());
	 
	 //Dropdown1
	 ap.getProductcategory().sendKeys("Furniture");
	
	 ap.getQuantity().sendKeys(Quantity);
	 
     ap.getPrice().sendKeys(Price);
	//DropDown2
	 ap.getVendorid().sendKeys("VID_001");
	 
	 ap.getAddBTN().click();
	 
	//validation
	    Thread.sleep(5000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Wutil.waitforVisibilityofElement(driver, toast);
	    String msg = toast.getText();
		
		/*if(msg.contains(Productname))
		{
			System.out.println("Product successfully Added");
		}
		else
		{
			System.out.println("Product not Added");
		}*/
	    
	    

		//hp.getToastCloseBTN().click();
		
	}

}
