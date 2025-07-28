package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	
	//This is for Implicitly wait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	
	//This is for ExplicitlyWait
	public void waitforVisibilityofElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	//This is for switchtoFrame using Index
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	
	//This is for switchtoFrame using Name
	public void switchtoFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	
	//This is for switchtoFrame using frameelement
	public void switchtoFrame(WebDriver driver,WebElement frameelement)
	{
		driver.switchTo().frame(frameelement);
	}
	
	
	//This is for switchto Alert POPUP Accept
	public void switchToAlertandAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	
	//This is for switchto Alert POPUP Dismiss
	public void switchToAlertandDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	//This is for switchto Alert to fetch TEXT
	public String SwitchToAlertAndgetText(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	
	//This is for switchto Alert to SENDKEYS
	public void switchToAlertAndSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	//This is for Selecting INDEX
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);	
	}
	
	
	//This is for Selecting VALUE
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);	
	}
	
	
	//This is for Selecting VISIBLETEXT
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);;	
	}
	
	
	//This is for MouseOvering 
	public void mouseHoveronWebElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	//This is for clickonWebElement 
	public void clickonWebElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	
	//This is for doubleclickOnWebElement
	public void doubleclickOnWebElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	//This is for Rightclick On WebElement
	public void rightclickOnWebElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	//This is for Passing Input On WebElement
	public void passinput(WebDriver driver,WebElement element,String text)
	{
		Actions act=new Actions(driver);
		act.click(element).sendKeys(text).perform();
	}
	
	
	//This is for Fetching Allwindows of WebPage
	public void switchToWindow(WebDriver driver)
	{
		Set<String> allwindId = driver.getWindowHandles();
		for(String id:allwindId)
		{
			driver.switchTo().window(id);
		}
	}
	
	
	//This is for Taking ScreenShot of WebPage
	public void takesScreenshot(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./errorShots"+filename+".png");
		FileHandler.copy(src, des);
	}
	
	
	//This is Scrolling to WebPage
	public void toscrollby(WebDriver driver,int x,int y)
	{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
}
