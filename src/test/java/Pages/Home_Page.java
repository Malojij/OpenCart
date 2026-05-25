package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage 
{

	public Home_Page(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']") 	WebElement ClickMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")	WebElement Registraion;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']") WebElement Login;
	
	public void ClickMyAccount() 
	{
		ClickMyAccount.click();
	}

	public void Registration() 
	{
		Registraion.click();
	}
	
	public void clicklogin()
	{
		Login.click();
	}
}
