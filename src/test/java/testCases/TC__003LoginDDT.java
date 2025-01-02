package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;
import utilities.Dataproviders;


public class TC__003LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=Dataproviders.class,groups="Datadriven")
	public void verify_logindata(String email, String pwd, String exp) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Email: " + email + ", Password: " + pwd + ", Expected: " + exp);
		try {
			HomePage hp1=new HomePage(driver);
			hp1.ClickRegister();
			System.out.println("something went rong");
			
			
			
			LoginPage lp1=new LoginPage(driver);
			lp1.setemail(email);
			lp1.setpssword(pwd);
			lp1.clicksigin();
			
			
			System.out.println("something went rong1");
			
		
			Myaccountpage ac=new Myaccountpage(driver);
			boolean profile=ac.isMyaccountpageExist();
			
			System.out.println("something went rong2");
			Assert.assertTrue(profile);
			Assert.assertTrue(true);
			System.out.println("something went rong3");
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(profile==true)
				{
					
					ac.clickLogoff();
					Assert.assertTrue(true);
				}
				
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
				{
				if(profile==true)
					Assert.assertTrue(false);
				}
			else
			{
				Assert.assertTrue(true);
			}
		}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("**** Ended TC 3****");
	}
}