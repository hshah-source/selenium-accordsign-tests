package com.accordsign.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accordsign.qa.base.TestBase;

public class HomePage extends TestBase{

	// Constructor
		public HomePage() {

			PageFactory.initElements(driver, this);
			
		}
	
		// Page Factory - OR
		
		
		@FindBy(id = "Email")
		WebElement username;
		
		
		
		// Actions
		
		
		
		public String validateHomePageTitle() throws InterruptedException {
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		
}
