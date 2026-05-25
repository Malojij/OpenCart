package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BasePage
{

	
	public  Login_Page(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy (xpath = "//input[@id='input-email']") WebElement loginEmail;
	@FindBy (xpath = "//*[@id=\"input-password\"]") WebElement loginPswd;
	@FindBy (xpath = "//button[normalize-space()='Login']") WebElement loginButton;


	
	public void txtloginemail(String loginemail)
	{
		loginEmail.sendKeys(loginemail);
	}
	
	public void txtloginpswd(String loginpswd)
	{
		loginPswd.sendKeys(loginpswd);
	}
	
	public void btnlogin()
	{
		loginButton.click();
	}
	
}
