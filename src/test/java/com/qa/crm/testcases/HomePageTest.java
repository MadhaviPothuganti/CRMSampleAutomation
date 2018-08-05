package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.crm.base.BaseTestPage;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class HomePageTest extends BaseTestPage{

	LoginPage loginpage;
	HomePage  homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	DealsPage dealspage;
	
	public HomePageTest() {
		super();//this call super class constructor(TestBase) to initialize the properties
	}
	// Test cases should be separated ---independent with each other
	//before each test case-- launch browser and login
	//@test -- execute test case
	//after each test case - close the browse
		
	@BeforeMethod
	public void setUp() {
		intialization();//Initialize the browser and driver
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		dealspage = new DealsPage();
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
				
	}
	
	
	@Test(priority=1)
	public void verifyUserName() {
		testutil.switchToFrame();
		homepage.validateNameLabel();
	}
	
	
	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage title is incorrect");
	}
	
	@Test(priority=3)
	public void verfiyContactsLinkTest() {
		testutil.switchToFrame();
		contactsPage = homepage.getContactsPage();
		
	}
	@Test(priority = 4)
	public void verifyDealsPageLink() {
		homepage.validateDeleasLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
