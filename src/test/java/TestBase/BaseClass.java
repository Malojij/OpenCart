package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	public Logger log;
	public Properties properties;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws IOException
	{
		
		//Loading config file

		FileReader file=new FileReader(".//src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
		
		
		log = LogManager.getLogger(this.getClass()); //for logging
		
		switch (browser.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser name..."); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(properties.getProperty("appurl"));
		driver.manage().window().maximize();
		
		
		//Loading log-file in base class
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
