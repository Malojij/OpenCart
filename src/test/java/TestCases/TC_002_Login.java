package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.Home_Page;
import Pages.Login_Page;
import Pages.MyAccount_Page;
import TestBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	SoftAssert sa;
	@Test
	public void verify_Login()
	{
		
		log.info("Clicking Login");
		Home_Page hp = new Home_Page(driver);
		hp.ClickMyAccount();
		hp.clicklogin();
		
		
		Login_Page lp = new Login_Page(driver);
		lp.txtloginemail(properties.getProperty("email"));
		lp.txtloginpswd(properties.getProperty("password"));
		lp.btnlogin();
	
		MyAccount_Page ma = new MyAccount_Page(driver);
		
		if(ma.isMyAccountPageExists()==true)
		{
			log.info("Login Successfull");
			Assert.assertTrue(true, "Login Success");
		}
		else
		{
			log.info("Login not successfull");
			Assert.fail();
		}
		
		
		
		
		
}

}
