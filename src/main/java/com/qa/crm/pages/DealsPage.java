package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BaseTestPage;

public class DealsPage extends BaseTestPage {

   @FindBy(xpath="//td[contains(text(),'Deals')]")
   WebElement dealsLabel;
   
   @FindBy(xpath="//legend[contains(text(),'Deal')]")
   WebElement newdealsLabel;
   
  //Initialize the page objects
   public DealsPage() {
	   PageFactory.initElements(driver, this);
	   
   }
  //Actions
   
   public boolean validateDealsLabel() {
	   return dealsLabel.isDisplayed();
	   	   
   }
  
   public boolean validateNewDealsLabel() {
	   return newdealsLabel.isDisplayed();
	   	   
   }
  


}
