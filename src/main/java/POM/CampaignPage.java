package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignname;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignstatus;
	
	@FindBy(name="targetSize")
	private WebElement Targetsize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement closedate;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createBTN;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getCampaignstatus() {
		return campaignstatus;
	}

	public WebElement getTargetsize() {
		return Targetsize;
	}

	public WebElement getClosedate() {
		return closedate;
	}

	public WebElement getCreateBTN() {
		return createBTN;
	}
	
	
	
}
