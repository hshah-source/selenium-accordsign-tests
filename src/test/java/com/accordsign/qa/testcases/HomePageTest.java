package com.accordsign.qa.testcases;

import org.testng.Assert;
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
		loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test
	public void ValidateHomePageTitleTest() throws InterruptedException {
		
		String HomePageTitle = homepage.validateHomePageTitle();
		System.out.println("HomePageTitle-"+HomePageTitle);
		Assert.assertEquals(HomePageTitle,"Accordsign | Home Page", "Home Page Title is not matched");
		
	}
	
	
	
}
