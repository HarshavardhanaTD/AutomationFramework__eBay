package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//body/div[@class='block header']/div[@id='box-137014']/div[1]")
	WebElement msgHeading;

	@FindBy(xpath="//span[normalize-space()='Log off']")
	WebElement linkLogoff;
	
	
	public boolean isMyaccountpageExist()
	{
		try
	{
		return(msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
	}
	
	public void clickLogoff()
	{
		linkLogoff.click();
	}
}
