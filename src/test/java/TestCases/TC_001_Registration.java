package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Home_Page;
import Pages.Registration_Page;
import TestBase.BaseClass;


public class TC_001_Registration extends BaseClass
{
	
	
	@Test
	public void account_registration () 
	{
		log.info("****Starting " +this.getClass()+ " ****");
		
		try {
			
			Home_Page hp=new Home_Page(driver);
			log.info("Clicking My account");
			hp.ClickMyAccount();
			log.info("Clicking My Registration");
			hp.Registration();
			
			log.info("Sending data to the registration fields	");
			Registration_Page rp = new Registration_Page(driver);
			rp.setFirstName("Maloji");
			rp.setLastname("Jadhav");
			rp.setEmail(properties.getProperty("email"));
			rp.setPassword(properties.getProperty("password"));
			
			rp.chkPrivacyCheck();
			rp.btnClickRegistration();
			
			log.info("Validating expected message..");
			String confirmMsg = rp.txtConfirmationMsg();
			
			if(confirmMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
				log.info("Account created");
			}
			else
			{
				log.error("Test failed: ");
				Assert.fail();
				
			}
			
		}
		catch (Exception e)
		{
			Assert.fail("Test failed: " + e.getMessage());
		} 	
		finally
		{
			log.info("TC_001_Registration Executed" +"\\n");
		}
		
	}
	
	
	

}
