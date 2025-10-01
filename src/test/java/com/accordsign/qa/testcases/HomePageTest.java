package com.accordsign.qa.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	
	
	@Test(priority=1)
	public void ValidateGetStartedPopup() throws InterruptedException {
		
		 SoftAssert softAssert = new SoftAssert();
		
		
		 // Validate each Image
	        softAssert.assertTrue(homepage.isImageValid(homepage.validateGetStartedPopupImage1()), 
	                "Broken Image Found: start with document");

	        softAssert.assertTrue(homepage.isImageValid(homepage.validateGetStartedPopupImage2()), 
	                "Broken Image Found: Get Signature");

	        softAssert.assertTrue(homepage.isImageValid(homepage.validateGetStartedPopupImage3()), 
	                "Broken Image Found: Keep it All in One Place");
		
		
	     // Validate each Title
		
	        softAssert.assertEquals(homepage.validateGetStartedPopupTitle1(), "Start with Document");
	        
	        softAssert.assertEquals(homepage.validateGetStartedPopupTitle2(), "Get Signature");
	        
	        softAssert.assertEquals(homepage.validateGetStartedPopupTitle3(), "Keep it All in One Place");
		
		
	     // Validate each Text
	        
	        softAssert.assertEquals(homepage.validateGetStartedPopupText1(), "Upload Pdf, Word, Excel, and More From Your Computer or Cloud Storage Provider");
	        
	        softAssert.assertEquals(homepage.validateGetStartedPopupText2(), "Place Field on Your Document To Guide Recipients Where to Sign and Enter Information.");

	        softAssert.assertEquals(homepage.validateGetStartedPopupText3(), "Track and Organize Your Document to Get Business Done.");

		
	        homepage.validateGetStartedPopupBtn(); 
		
		
		 softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void ValidateHomePageTitleTest() throws InterruptedException {
		
		String HomePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(HomePageTitle,"Accordsign | Home", "Home Page Title is not matched");
		
	}
	
	@Test(priority=3)
	public void ValidateSettingMenuStatusInActive() throws InterruptedException {
		
		Assert.assertEquals(homepage.validateSettingMenuStatus(), "display: none;", "On Home page Setting Menu Is Active after login");
		
	}
	
	@Test(priority=4)
	public void verifySettingsMenuItemsTest() {
	    List<String> actualMenuItems = homepage.validateSettingMenuItems();

	    // Example: expected menu items
	    List<String> expectedMenuItems = List.of("My Settings", "Profile", "Security", "Login Methods", "My Signatures", "Account", "Business Profile", "Subscription");

	    Assert.assertEquals(actualMenuItems, expectedMenuItems, " Menu items do not match!");
	}
	
	@Test(priority=5)
	public void ValidateSettingProfileLinkSelected() {
		
		String ProfileLinkStatus = homepage.validateMySettingProfileLinkSelected();
		ProfileLinkStatus.contains("Active");
		System.out.println(ProfileLinkStatus);
	}
	
	@Test(priority=5)
	public void validateMySettingMySignaturesLinkSelected() {
		
		String ProfileLinkStatus = homepage.validateMySettingMySignaturesLinkSelected();
		ProfileLinkStatus.contains("Active");
		System.out.println(ProfileLinkStatus);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
}
