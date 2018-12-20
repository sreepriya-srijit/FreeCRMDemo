
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		prop =new Properties();
		try {
			FileInputStream fs = new FileInputStream("D:/Workspace- priya/Naveen_Selenium_Automation_Lab/FreeCRMDemo/src/main/"
					+ "java/com/crm/qa/config/config.properties");
			prop.load(fs);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not present");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("input is null");
			e.printStackTrace();
		}			
	}
	
	public void invokeBrowser()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Applcation_SW_ IDE/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Applcation_SW_ IDE\\geckodriver-v0.19.1-win64/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));		
	}

}
