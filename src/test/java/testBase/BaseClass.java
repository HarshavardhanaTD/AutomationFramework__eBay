package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;
    

    @BeforeClass(groups= {"Sanity","Regression","Master"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException, InterruptedException {
        // Load config.properties file
  
    	Thread.sleep(10000);
        FileReader file = new FileReader("src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
    	
        // Initialize logger
        logger = LogManager.getLogger(this.getClass());
		
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"));
        
        {
        	
        DesiredCapabilities capability=new DesiredCapabilities();
        
        	
        	if(os.equalsIgnoreCase("windows"))
        	{
        		capability.setPlatform(Platform.WIN11);
        	}
        	else if(os.equalsIgnoreCase("mac"))
        	{
        		capability.setPlatform(Platform.MAC);
        	}
        	else
        	{
        		System.out.println("No matching os");
        		return;
        	}
        
        
        switch(br.toLowerCase())
        {
        case "chrome": capability.setBrowserName("chrome");break;
        case "edge": capability.setBrowserName("MicrosoftEdge");break;
        case "firefox": capability.setBrowserName("firefox");break;
        default: System.out.println("invalid browser"); return;
        }
        driver=new RemoteWebDriver(new URL("http://192.168.29.121:4444/wd/hub"), capability);
        }	
        
        if(p.getProperty("execution_env").equalsIgnoreCase("local"));
        
        {
        switch(br.toLowerCase())
        {
        case "chrome": driver=new ChromeDriver();break;
        case "edge": driver=new EdgeDriver();break;
    
        default: System.out.println("invalid browser"); return;
        }
        }	
        
        
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));          //reading URL from property file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
        }
	public String randomeString()

	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
				return generateString;
	}
	
	@SuppressWarnings("deprecation")
	public String randAlphaNumeric()

	{
		String phonenum=RandomStringUtils.randomNumeric(8);
				return phonenum;
	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
}
	
	
