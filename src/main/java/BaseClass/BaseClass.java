package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesFileUtility;
import WebDriverUtility.WebDriverUtility;


public class BaseClass 
{
	public  WebDriver driver=null;
	public static  WebDriver sdriver=null;
	public PropertiesFileUtility putil=new PropertiesFileUtility();
	
	@BeforeSuite(groups= {"smoke", "regression"})
    public void beforesuite()
	{
			System.out.println("DB Connectivity open");
	}
	
	@BeforeTest(groups= {"smoke", "regression"})
	public void beforetest()
	{
		System.out.println("Pre-condition");
	}
	
	
	//ForCross Browser Testing we shld add this statement 
	//@Parameters("BROWSER")		
	@BeforeClass(groups= {"smoke", "regression"})
	public void beforeclass(/*String BROWSER*/) throws IOException
	{
		driver=sdriver;
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		if(BROWSER.equals("Edge"))
		 {
			 driver=new EdgeDriver();
		 }
		else if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		else if(BROWSER.equals("Firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		
		driver.manage().window().maximize();
		System.out.println("launching Browser");
		
	}
	
	@BeforeMethod(groups= {"smoke", "regression"})
	public void beforeMethod() throws IOException
	{
		String BROWSER = putil.getdatafrompropertiesfile("Browser");
		String URL = putil.getdatafrompropertiesfile("URL");
		String USERNAME = putil.getdatafrompropertiesfile("Username");
		String PASSWORD = putil.getdatafrompropertiesfile("Password");
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBTN().click();
		System.out.println("Login Done");
	}

	@AfterMethod(groups= {"smoke", "regression"})
	public void afterMethod() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
	    Thread.sleep(6000);
	    hp.getUserIcon().click();
		hp.getLogoutBTN().click();
		System.out.println("Logout Done");
	}

    @AfterClass(groups= {"smoke", "regression"})
    public void afterClass()
    {
    	
    	driver.quit();
    	System.out.println("Closing Browser");
    }

    @AfterTest(groups= {"smoke", "regression"})
    public void afterTest()
    {
    	System.out.println("Post-condition");
    }
    
    @AfterSuite(groups= {"smoke", "regression"})
    public void aftersuite()
		{
			System.out.println("DB Connectivity close");
		}
}

