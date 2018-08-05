package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTestPage;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class DealsPageTest extends BaseTestPage {

    LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	TestUtil testutil;

	
	public DealsPageTest(){
		super();//this call super class constructor(TestBase) to initialize the properties
		
	}
   
	@BeforeMethod
	public void setUP() {
		intialization();//Initialize the browser and driver
		loginpage = new LoginPage();
		homepage = new HomePage();
		dealspage = new DealsPage();
		testutil = new TestUtil();
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		//loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyDealsPage() {
		testutil.switchToFrame();
		homepage.validateDeleasLink();
		Assert.assertTrue(dealspage.validateDealsLabel());
		
	}
	
	@Test(priority=2)
	public void verifynewDelasLink() {
		testutil.switchToFrame();
		homepage.validateNewDealsLink();
		Assert.assertTrue(dealspage.validateNewDealsLabel());
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
