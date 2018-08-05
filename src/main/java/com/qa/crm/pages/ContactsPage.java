package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.base.BaseTestPage;

public class ContactsPage extends BaseTestPage{
	//PageFactory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
			
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	WebElement newContactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='text' and  @name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//td/a[contains(text(),'Madhoo Bandi')]")
	WebElement contactName;
	
	//Initialize the page objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
			
	public boolean validateNewContactsLabel() {
		return newContactsLabel.isDisplayed();
	}

	public void validateCreateNewcontact(String title,String ftName,String ltname,String comp) {
		Select select = new Select(driver.findElement(By.xpath("//Select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	
	public boolean validateContactName() {
		return contactName.isDisplayed();
	}
	
}
