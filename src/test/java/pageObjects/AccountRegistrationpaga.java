package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpaga extends BasePage{

	public AccountRegistrationpaga(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"create\"]")
	
	WebElement btnnewaccount;
	
	
	@FindBy(xpath="//input[@id='registration-firstname']")
	WebElement txtfristname;
	
	@FindBy(xpath="//input[@id='registration-lastname']")
	WebElement txtlastname;
	
	
	@FindBy(xpath="//input[@id='registration-password']")
	WebElement txtpassword;
	
	
	@FindBy(xpath="//input[@id='registration-confirmation']")
	WebElement txtconfpassword;

		 
	
	@FindBy(xpath="//input[@id='registration-email_address']")
	WebElement txtemail;
	
	
	
	@FindBy(xpath="//input[@id='registration-username']")
	WebElement txtusrname;	
	
	
	@FindBy(xpath="//*[@id=\"register_buttons_box\"]/div[1]/div/label/div/div/span[2]")
	WebElement agreebutton;	
	
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement loginbutton;	
	
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[1]")
	WebElement popup;
	
	
	public void Creatnewbut()
	{
		btnnewaccount.click();
	}
	
	public void setFname(String fname)
	{
		txtfristname.sendKeys(fname);
	}
	
	public void setLname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setPassword(String email)
	{
		txtpassword.sendKeys(email);
	}
	
	public void setConfirmPassword(String confpwd)
	{
		txtconfpassword.sendKeys(confpwd);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	
	public void setUsername(String uname)
	{
		txtusrname.sendKeys(uname);
	}
	
	public void Agreebutton()
	{
		agreebutton.click();
	}
	
	public void Loginbutton()
	{
		loginbutton.click();
	}
	
	public void Popupmsg()
	{
		popup.click();
	}

	
}
