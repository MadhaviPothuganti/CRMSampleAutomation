package com.qa.crm.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTestPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends BaseTestPage {

	LoginPage loginpage;
	HomePage homepage;
	//constructor
	
	
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
	  super();//this will initialize the property file, From BaseTestPage Constructor
	}
	
	@BeforeClass
	public void setUp() {
		log.info("*************************** Starting test cases execution  *********************************");
		intialization();//intializing browser..etc from BaseTestClass
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String Title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Free CRM software in the cloud powers sales and customer service");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	
	@Test(priority=2)
	public void validateLogo() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
	
	}
	
	@Test(priority=3)
	public void doLoginTest() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
		
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

	}
	
	
}
