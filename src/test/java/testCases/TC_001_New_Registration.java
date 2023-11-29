package testCases;


import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;


public class TC_001_New_Registration extends BaseClass{
	@Test
	public void OC_account_Registration() {
		logger.debug("*********applicatio logs**********");
		logger.info("*****Starting Execution TC_001_New_Registration*******");
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("clicking my account");
		hp.click_myAccount();
		logger.info("clicking register");
		hp.click_register();
		logger.info("entering firstname");
		rp.setFirstname(rb.getString("firstname"));
		logger.info("entering lastname");
		rp.setLastname(rb.getString("lastname"));
		logger.info("entering email");
		rp.setEmail(rb.getString("email"));
		logger.info("entering password");
		rp.setPassword(rb.getString("password"));
		
		logger.info("clicking checkbox privacy");
		rp.clickCheckbox();
		logger.info("clicking continue to create registration");
		rp.clickContinue();
		
	}

}
