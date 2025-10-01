package com.accordsign.qa.testcases;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accordsign.qa.base.TestBase;
import com.accordsign.qa.pages.HomePage;
import com.accordsign.qa.pages.LoginPage;
import com.accordsign.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ProfilePage profilepage;
	
	
	public ProfilePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
		profilepage = homepage.validateMySettingProfileLink();
	}
	
	
	@Test(priority=1)
	public void ValidateHomePageTitleTest() throws InterruptedException {
		
		String ProfilePageTitle = profilepage.validateProfilePageTitle();
		Assert.assertEquals(ProfilePageTitle,"Accordsign | Profile", "Profile Page Title is not matched");
		
	}
	
	
	@Test(priority = 2)
	public void ValidateAllLabelPlaceholderProfilePage() throws InterruptedException {
		
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		
		
		softAssert.assertEquals(profilepage.validateProfilePageHeading(), "Profile");
		softAssert.assertEquals(profilepage.validateFirstNameLabel(), "First Name");
		softAssert.assertEquals(profilepage.validateFirstNamePlaceHolder(), "Enter First Name");
		softAssert.assertEquals(profilepage.validateLastNameLebel(), "Last Name");
		softAssert.assertEquals(profilepage.validateLasttNamePlaceHolder(), "Enter Last Name");
		softAssert.assertEquals(profilepage.validatePhoneNumberLebel(), "Phone Number");
		softAssert.assertEquals(profilepage.validatePhoneNumberPlaceHolder(), "Enter Phone Number");
		softAssert.assertEquals(profilepage.validateEmailLabel(), "Work Email Address");
		softAssert.assertEquals(profilepage.validateRegionLabel(), "Region");
		softAssert.assertEquals(profilepage.validateTimeZoneLabel(), "Timezone");
		softAssert.assertEquals(profilepage.validateSelectImageBtnText(), "Select Image");
		softAssert.assertEquals(profilepage.validateRemoveBtnText(), "Remove");
		softAssert.assertEquals(profilepage.validateUpdateBtnText(), "Update");
		
		softAssert.assertAll(); // This will report all failures together
		
		
	}
	
	
	
	@Test(priority = 3)
	public void ValidateImageUploadAndRemoveOnProfile() throws Exception {
        
		SoftAssert softAssert = new SoftAssert();
		
		String imagePath = Paths.get("C:\\Users\\Harsh Shah\\eclipse-workspace\\AcccordSignTest\\src\\test\\TestData\\ProfilePicture.jpg")
                                .toAbsolutePath().toString();

        profilepage.uploadImageWithRobot(imagePath);
        softAssert.assertEquals(profilepage.validateUpdateBtnValidation(), "Your profile was updated successfully!");
        softAssert.assertTrue(profilepage.ProfileImageIsDisplayed(), "Image not uploaded via Robot!");
        softAssert.assertTrue(profilepage.removeProfileImage(), "Image Removed!");
        softAssert.assertAll();
        
    }
	
	@Test(priority = 4)
	public void ValidateAllElementDeletePopup() throws InterruptedException {
		
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		
		profilepage.validateDeleteAccountLink();
		softAssert.assertTrue(profilepage.validatedeletePopup(), "Delete PopUp is not Displayed");
		softAssert.assertEquals(profilepage.validateDeletePopupTitle(), "Delete Account");
		softAssert.assertTrue(profilepage.validateDeletePopupBody(), "Warning message missing in popup.");
		softAssert.assertEquals(profilepage.validateDeletePopupCancelBtn(), "Cancel");
		softAssert.assertEquals(profilepage.validateDeletePopupOkBtn(), "Okay");
		softAssert.assertAll(); // This will report all failures together
		softAssert.assertTrue(profilepage.validatedeletePopupdisappear(), "Delete Account popup did not close after clicking close button.");

		
	}
	

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	
	
	

}
