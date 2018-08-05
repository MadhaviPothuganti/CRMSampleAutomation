package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.crm.util.TestUtil;
import com.qa.crm.util.WebEventListener;

public class BaseTestPage {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventlistner;
	
	public BaseTestPage(){
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\2018\\WorkSpace\\CRMProject1\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
	        prop.load(fis);
			fis.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		
	  }
	
	}
    public static void intialization() {
    	
    	String browser = prop.getProperty("browser");
    	if(browser.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\i839973\\Downloads\\ChromeDriver\\chromedriver.exe");
    		 driver = new ChromeDriver();
    	}else if(browser.equalsIgnoreCase("firefox")){
    	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\i839973\\Downloads\\FFDriver\\geckodriver.exe");
    	    	       	
    	}
    	
    	
    	 e_driver = new EventFiringWebDriver(driver);
         //now create object of EventListnerHandler to register it with EventFiringWebdriver
         eventlistner =  new WebEventListener();
         e_driver.register(eventlistner);
         driver = e_driver;
    	
    	
    	driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECITELY_WAIT, TimeUnit.SECONDS);
      
        
        driver.get(prop.getProperty("url"));
    	
    }




}
