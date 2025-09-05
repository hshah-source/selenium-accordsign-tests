package com.accordsign.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accordsign.qa.base.TestBase;
import com.accordsign.qa.pages.HomePage;
import com.accordsign.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		
		super();
	}

	
	@BeforeMethod
	public void setUp() {

		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void ValidateHomePageTitleTest() throws InterruptedException {
		
		String HomePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(HomePageTitle,"Accordsign | Home", "Home Page Title is not matched");
		
	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
}
