package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass{

	@Test
	public void verify_login()
	{
		try {
	
		logger.info("*******Starting TC002 Login Test*******");
		HomePage hp=new HomePage(driver);
		hp.ClickRegister();
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpssword(p.getProperty("password"));
		Thread.sleep(3000);
		lp.clicksigin();
		
		Myaccountpage maccount= new Myaccountpage(driver);
		boolean targetpage=maccount.isMyaccountpageExist();
		Assert.assertEquals(targetpage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		logger.info(" Finished TC002 Login Test  ");
			}
}
