package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTestPage;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

public class ContactsPageTest extends BaseTestPage {
     LoginPage loginpage;
     TestUtil testutil;
     ContactsPage contactspage;
     String sheetName = "contacts";
	
	
	@BeforeMethod
	public void setUp() {
		intialization();//Initializing the browser
		loginpage = new LoginPage();
		contactspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password")).getContactsPage();
		testutil = new TestUtil();
	}
	
	@Test(priority=1)
	public void verifyContactsLabel() {
		testutil.switchToFrame();
		Assert.assertTrue(contactspage.validateContactsLabel(),"Contacts label is missing");
	}
	//loading the sheet and values
	@DataProvider
	public Object[][] getCRMTestdata() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	//passing values for each test	
	@Test(priority=2,dataProvider = "getCRMTestdata")
	public void verifyCreateNewcontactTest(String title,String firstname,String lastname, String company ) {
		testutil.switchToFrame();
		contactspage.validateCreateNewcontact(title, firstname, lastname, lastname);
	}
	
	@Test(priority=3)
	public void verifyContactName() {
		testutil.switchToFrame();
		Assert.assertTrue(contactspage.validateContactName());
	}
				
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
