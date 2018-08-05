package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BaseTestPage;

public class HomePage  extends BaseTestPage{
     
	//PageFactory
	@FindBy(xpath ="//td[contains(text(),'john paul')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deleasLink;
	
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[6]/a")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	WebElement newdealsLink;
	
	//Initializing the page objects
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	
	
	public String validateHomePageTitle() {
		return driver.getTitle();
       }
	
	public boolean validateNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage getContactsPage() {
		 contactsLink.click();
		 return new ContactsPage();
		 
	}
	
	public void validateNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	public DealsPage validateDeleasLink() {
		deleasLink.click();
		return new DealsPage();
	}
	
	public void validateNewDealsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(deleasLink).build().perform();		
		newdealsLink.click();
	}
	
	public TasksPage validateTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
