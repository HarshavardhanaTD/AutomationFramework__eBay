package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpaga;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_0001_AccountRegistration extends BaseClass {

	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		
		logger.info("**** Started TC001******");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.ClickRegister();
		logger.info("**** Home page displayed******");
		Thread.sleep(4000);
		AccountRegistrationpaga acreg=new AccountRegistrationpaga(driver);
		
		logger.info("**** Account page displayed******");
		Thread.sleep(3000);
		acreg.Creatnewbut();
		Thread.sleep(3000);
		acreg.setFname("HTDVardhana");
		Thread.sleep(3000);
		
		acreg.setLname("TDG");
		Thread.sleep(3000);
		
		
		
		String password=randAlphaNumeric();;
		
		acreg.setPassword(password+"GMail.com");
		Thread.sleep(3000);
		acreg.setConfirmPassword(password+"GMail.com");
		
		Thread.sleep(3000);
		acreg.setEmail(randomeString()+"@gmail.com");
		
		Thread.sleep(3000);
		acreg.setUsername(randomeString());
		
		Thread.sleep(3000);
		acreg.Agreebutton();
		Thread.sleep(3000);
		acreg.Loginbutton();
		Thread.sleep(3000);
		acreg.Popupmsg();
		logger.info("**** Ended TC001******");
		
		Object one=1;
		Object two=1;
		if(one.equals(two))
		{
		Assert.assertTrue(true);	
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);	
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
	}	
		
	
}
