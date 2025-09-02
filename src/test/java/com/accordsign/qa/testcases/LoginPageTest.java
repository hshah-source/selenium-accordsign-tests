package com.accordsign.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accordsign.qa.base.TestBase;
import com.accordsign.qa.pages.HomePage;
import com.accordsign.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {

		super();

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginpage = new LoginPage();

	}

	// TestCases related to Text and Title

	@Test(priority=1)
	public void validateLoginPageTitleTest() {

		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Accordsign | Login");
	}

	@Test(priority=2)
	public void validateLoginPageHeadingTest() {

		String LoginPageHeading = loginpage.validateLoginPageHeading();
		Assert.assertEquals(LoginPageHeading, "Login", "Heading Login is Mismatched");

	}

	@Test(priority=3)
	public void validateEmailLabelTest() {

		String EmailLabel = loginpage.validateEmailLabel();
		Assert.assertEquals(EmailLabel, "Email ID", "Email Label is Mismatched");

	}

	@Test(priority=4)
	public void validatePasswordLabelTest() {

		String PasswordLabel = loginpage.validatePasswordLabel();
		Assert.assertEquals(PasswordLabel, "Password", "Password Label is Mismatched");

	}

	@Test(priority=5)
	public void validateEmailPlaceHolderTest() {

		String emailPlaceHolder = loginpage.validateEmailPlaceHolder();
		Assert.assertEquals(emailPlaceHolder, "Enter Email ID", "Email PlaceHolder is Mismatched");

	}

	@Test(priority=6)
	public void validatePasswordPlaceHolderTest() {

		String passwordPlaceHolder = loginpage.validatePasswordPlaceHolder();
		Assert.assertEquals(passwordPlaceHolder, "Enter password", "Password PlaceHolder is Mismatched");

	}


	@Test(priority=8)
	public void validateLoginBtnTextTest() {

		String LoginBtnText = loginpage.validateLoginBtnText();
		Assert.assertEquals(LoginBtnText, "Login", "Login Text is Mismatched");

	}

	@Test(priority=9)
	public void validateSignUpText1Test() {

		String SignUpText1 = loginpage.validateSignUpText1();
		Assert.assertEquals(SignUpText1,
				"I agree to the Accordsign Terms and acknowledge how my data is used and protected as outlined in the Privacy Policy.",
				"SignUp Text1 is Mismatched");

	}

	@Test(priority=10)
	public void validateSignUpText2Test() {

		String SignUpText2 = loginpage.validateSignUpText2();
		Assert.assertEquals(SignUpText2, "Don’t have an account? Sign Up", "SignUp Text2 is Mismatched");

	}

	// TestCases Related to Images

	@Test(priority=11)
	public void validateDigitalSignatureLogoisDisplayed() {

		Assert.assertTrue(loginpage.validateDigitalSignatureLogoDisplayed(),
				"Digital Signature logo is not displayed.");

	}

	@Test(priority=12)
	public void validateAccordSignLogoisDisplayed() {

		Assert.assertTrue(loginpage.validateAccordSignLogoDisplayed(), "AccordSign logo is not displayed.");

	}

	@Test(priority=13)
	public void validateCopyRightisDisplayed() {

		Assert.assertTrue(loginpage.validateCopyRightDisplayed(), "CopyRight is not displayed.");

	}

	@Test(priority=14)
	public void validateSeedDataLogoisDisplayed() {

		Assert.assertTrue(loginpage.validateSeedDataLogoDisplayed(), "SeedData logo is not displayed.");

	}

	// TestCases Related Functionality

//	@Test(priority = 15)
//	public void validateAccordSignTermsLinkTest() {
//
//		boolean isRedirected = loginpage.validateaccordSignTermsLink();
//		Assert.assertTrue(isRedirected, "AccordSign Terms link is not redirecting to any page!");
//
//	}

//	@Test(priority = 16)
//	public void validatePrivacyPolicyLinkTest() {
//
//		boolean isRedirected = loginpage.validatePrivacyPolicyLink();
//		Assert.assertTrue(isRedirected, "Privacy Policy link is not redirecting to any page!");
//
//	}


	@Test(priority = 17)
	public void validatePasswordMaskingTest() {
		
		Assert.assertTrue(loginpage.PasswordMasked(), "Password is not masked!");

	}
	
//	@Test(priority=18)
//	public void validateValidLoginTest() throws InterruptedException {
//
//		homepage = loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
//		Assert.assertEquals(homepage.validateHomePageTitle(),"Accordsign | Home Page","Not navigated to Home page!");
//
//	}


	// =================================================Create New Test Class For
	// ForgotPassword
	// Functionality================================================//

	// @Test(priority=16)
	public void validateForgotPasswordTest() throws InterruptedException {

		loginpage.validateForgotPasswordLink(prop.getProperty("ForgotMail"));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
