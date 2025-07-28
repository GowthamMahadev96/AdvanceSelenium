package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./ConfigData/NinjaCredetails.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String Brows = pro.getProperty("Browser");
		String url = pro.getProperty("URL");
		String UN = pro.getProperty("Username");
		 String PW = pro.getProperty("Password");
		 
		 WebDriver driver=null;
		 
		 if(Brows.equals("Firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 if(Brows.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 if(Brows.equals("Edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.get(url);
		    driver.findElement(By.id("username")).sendKeys(UN);
			driver.findElement(By.id("inputPassword")).sendKeys(PW);
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		    driver.close();
		 
		 
		 
		 
		 
	}

}
