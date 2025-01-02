package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	@FindBy(xpath="//input[@id='login-email_address']")
				 
	WebElement txtemailaddress;
	
	
	@FindBy(xpath="//input[@id='login-password']")
				 
	WebElement txtpasswordaddress;
	
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	 
	WebElement btnsignin;
	public void setemail(String email)
	{
		txtemailaddress.sendKeys(email);
	}
	
	public void setpssword(String pwd)
	{
		txtpasswordaddress.sendKeys(pwd);
	}

	public void clicksigin()
	{
		btnsignin.click();
	}
}
