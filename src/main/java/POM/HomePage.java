package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createcampaign;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement AddProductBTN;
	
	@FindBy(className="user-icon")
	private WebElement userIcon;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toast;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement toastCloseBTN;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public WebElement getAddProductBTN() {
		return AddProductBTN;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutBTN() {
		return logoutBTN;
	}

	public WebElement getToast() {
		return toast;
	}

	public WebElement getToastCloseBTN() {
		return toastCloseBTN;
	}
	
	
	
	
}
