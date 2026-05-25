package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Registration_Page extends BasePage

{
	
	public Registration_Page(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement FirstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement LastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement Email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement Password;
	@FindBy(xpath = "//input[@name='agree'] [@class='form-check-input']") WebElement PrivacyCheck;
	@FindBy(xpath = "//button[normalize-space()='Continue']") WebElement RegisterButton;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement txtConfirmMsg;
	
	
	public void setFirstName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		LastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setPassword(String pswd)
	{
		Password.sendKeys(pswd);
	}
	
	public void chkPrivacyCheck()
	{
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.SPACE).keyUp(Keys.SPACE).perform();
	}
	
	public void btnClickRegistration()
	{
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.SPACE).keyUp(Keys.SPACE).perform();
		
	}
	
	
	public String txtConfirmationMsg()
	{
		try
		{
			String msg=txtConfirmMsg.getText();
			return msg;
		}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
}



