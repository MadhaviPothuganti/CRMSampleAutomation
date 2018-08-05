package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.BaseTestPage;

public class LoginPage extends BaseTestPage {

//PageFactory
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
		
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css="input[class='btn btn-small']")
	WebElement loginBtn;
	
//Initializing the page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//Actions
	 public String validateLoginPageTitle() {
		return driver.getTitle();
	 }

	 public boolean validateLogo() {
		return logo.isDisplayed();
	 }
    
	 public HomePage doLogin(String un,String pw) {
		 username.sendKeys(un);
		 password.sendKeys(pw);
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 System.out.println("Madhoo - " + loginBtn.getText());
		 WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(ele).click().perform();
		 // loginBtn.click();
		 return new HomePage();
	 }







}
