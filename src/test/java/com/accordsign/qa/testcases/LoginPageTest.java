package com.accordsign.qa.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

	@Test(priority = 1)
	public void validateLoginPageTitleTest() {

		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Accordsign | Login");
	}

	@Test(priority = 2)
	public void validateAllElementsOnLoginPage() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		softAssert.assertEquals(loginpage.validateLoginPageHeading(), "Login");

		softAssert.assertEquals(loginpage.validateEmailLabel(), "Email ID");

		softAssert.assertEquals(loginpage.validateEmailPlaceHolder(), "Enter Email ID");

		softAssert.assertEquals(loginpage.validatePasswordLabel(), "Password");

		softAssert.assertEquals(loginpage.validatePasswordPlaceHolder(), "Enter password");

		softAssert.assertEquals(loginpage.validateLoginBtnText(), "Login");

		softAssert.assertEquals(loginpage.validateSignUpText1(),
				"I agree to the Accordsign Terms and acknowledge how my data is used and protected as outlined in the Privacy Policy.");

		softAssert.assertEquals(loginpage.validateSignUpText2(), "Don’t have an account? Sign Up");

		softAssert.assertTrue(loginpage.validateDigitalSignatureLogoDisplayed(),
				"Digital Signature logo is not displayed.");

		softAssert.assertTrue(loginpage.validateAccordSignLogoDisplayed(), "AccordSign logo is not displayed.");

		softAssert.assertTrue(loginpage.validateCopyRightDisplayed(), "CopyRight is not displayed.");

		softAssert.assertTrue(loginpage.validateSeedDataLogoDisplayed(), "SeedData logo is not displayed.");
		
		softAssert.assertEquals(loginpage.validateForgotPasswordLinkText(), "Forgot Password");
		

		softAssert.assertAll();

	}

	// TestCases Functionality

	//@Test(priority = 3)
	public void validateAccordSignTermsLinkTest() {

		boolean isRedirected = loginpage.validateaccordSignTermsLink();
		Assert.assertTrue(isRedirected, "AccordSign Terms link is not redirecting to any page!");

	}

	//@Test(priority = 4)
	public void validatePrivacyPolicyLinkTest() {

		boolean isRedirected = loginpage.validatePrivacyPolicyLink();
		Assert.assertTrue(isRedirected, "Privacy Policy link is not redirecting to any page!");

	}

	@Test(priority = 5)
	public void validateLoginValidationMessageTest() {
		// Click the SignUp button without filling details
		loginpage.validateLoginBtn();

		// Get all toast messages
		List<String> actualToasts = loginpage.captureToastMessages();

		// Define expected messages
		List<String> expectedToasts = Arrays.asList("Password is required.", "Email address is required."

		);
		Assert.assertTrue(actualToasts.containsAll(expectedToasts) && expectedToasts.containsAll(actualToasts),
				"Toast messages did not match!");

	}

	@Test(priority = 6)
	public void validateLoginValidationMessageTest2() {

		loginpage.validateEmailTextBox("hshah@perigeon.abc");
		loginpage.validatePasswordTextBox("Harsh@123");

		loginpage.validateLoginBtn();

		// Get all toast messages
		List<String> actualToasts2 = loginpage.captureToastMessages();

		// Define expected messages
		List<String> expectedToasts2 = Arrays.asList("We couldn’t find an account with that email ID."

		);
		Assert.assertTrue(actualToasts2.containsAll(expectedToasts2) && expectedToasts2.containsAll(actualToasts2),
				"Toast messages did not match!");

	}

	@Test(priority = 7)
	public void validatePasswordMaskingTest() {

		Assert.assertTrue(loginpage.PasswordMasked(), "Password is not masked!");

	}

	// =================================================Create New Test Class For
	// ForgotPassword
	// Functionality================================================//

	@Test(priority = 8)
	public void validateForgotPasswordLinkEmailPageAllElement() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		loginpage.validateForgotPasswordLink();

		softAssert.assertEquals(loginpage.validateForgotPasswordTitle(), "Accordsign | Forgot Password");

		softAssert.assertEquals(loginpage.validateForgotPasswordHeading(), "Forgot Password");

		softAssert.assertEquals(loginpage.validateForgotPasswordText(),
				"Please enter your Email to reset the password");

		softAssert.assertEquals(loginpage.validateForgotPasswordEmailLabel(), "Email ID");

		softAssert.assertEquals(loginpage.validateForgotPasswordPlaceHolder(), "Enter Email ID");

		softAssert.assertEquals(loginpage.validateForgotPasswordSubmitbtn(), "Submit");

		softAssert.assertEquals(loginpage.validateForgotPasswordText1(), "Have a Password? Login");

		softAssert.assertEquals(loginpage.validateForgotPasswordText2(),
				"I agree to the Accordsign Terms and acknowledge how my data is used and protected as outlined in the Privacy Policy.");

		loginpage.validateForgotPasswordSubmit();

		softAssert.assertEquals(loginpage.validateForgotPasswordTosterMessage(), "Email address is required.");

		loginpage.validateForgotPasswordEmailTextBox("hshah@123.com");

		loginpage.validateForgotPasswordSubmit();

		softAssert.assertEquals(loginpage.validateForgotPasswordTosterMessage(),
				"We couldn’t find an account with that email ID.");

		loginpage.validateForgotPasswordEmailTextBox("hshah@123.");

		loginpage.validateForgotPasswordSubmit();

		softAssert.assertEquals(loginpage.validateForgotPasswordTosterMessage(),
				"That doesn’t look like a valid email.");

		loginpage.validateForgotPasswordEmailTextBox("hshah@perigeon.com");

		loginpage.validateForgotPasswordSubmit();

		softAssert.assertAll();
	}

	//@Test(priority = 9)
	public void validateForgotPasswordLinkOTPPageAllElement() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		loginpage.validateForgotPasswordLink();

		loginpage.validateForgotPasswordEmailTextBox("hshah@perigeon.com");

		loginpage.validateForgotPasswordSubmit();

		String email = prop.getProperty("email");

		softAssert.assertEquals(loginpage.getOTPPageTitle(), "Accordsign | Forgot Password");
		softAssert.assertEquals(loginpage.getOTPHeadingText(), "Check Your Email");
		softAssert.assertEquals(loginpage.getSentOTPMessage(), "We have sent an OTP to : hshah@perigeon.com");
		softAssert.assertTrue(loginpage.getSentOTPEmail().contains(email));
		softAssert.assertEquals(loginpage.getOTPInstructionText(),
				"Check your inbox & follow the instructions to get started.");

		loginpage.validateSubmitOTPBtn();

		softAssert.assertEquals(loginpage.getOTPValidationMessage(), "Please enter the OTP.");

		Thread.sleep(2000);

		loginpage.enterInvalidOTP();

		loginpage.validateSubmitOTPBtn();

		Thread.sleep(2000);

		softAssert.assertEquals(loginpage.getOTPValidationMessage(), "That OTP doesn’t look right. Please try again.");

		loginpage.clickResendLink();

		softAssert.assertEquals(loginpage.getOTPResendSuccessMessage(), "OTP sent successfully!");

		Thread.sleep(2000);

		softAssert.assertEquals(loginpage.isResendTextDisplayed(), "Didn’t Receive OTP? Resend");

		softAssert.assertEquals(loginpage.isLoginLinkDisplayed(), "Already have an account? Login");

		softAssert.assertAll();

	}

	//@Test(priority = 10)
	public void validateForgotPasswordLinkPasswordPageAllElement() throws InterruptedException {

		loginpage.validateSetPasswordPageDetails(prop.getProperty("ForgotMail"));

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		softAssert.assertEquals(loginpage.getPasswordPageTitle(), "AccordSign | ResetPassword");

		softAssert.assertEquals(loginpage.getPasswordHeadingText(), "Set a New Password");

		softAssert.assertEquals(loginpage.getPasswordlabelText(), "Password");

		softAssert.assertEquals(loginpage.getPasswordPlaceholderText(), "Enter password");

		softAssert.assertEquals(loginpage.getConfirmPasswordlabelText(), "Confirm Password");

		softAssert.assertEquals(loginpage.getConfirmPasswordPlaceholderText(), "Confirm password");

		softAssert.assertEquals(loginpage.getPasswordProgressText(), "Password Strength:");

		softAssert.assertEquals(loginpage.getPasswordStrengthText1(), " Atleast 1 Lowercase & 1 Uppercase");

		softAssert.assertEquals(loginpage.getPasswordStrengthText2(), " Atleast 1 Number (0-9)");

		softAssert.assertEquals(loginpage.getPasswordStrengthText3(), " Atleast 1 Special Character (!@#$%&*)");

		softAssert.assertEquals(loginpage.getPasswordStrengthText4(), " Minium 8 & Maximum 15 Characters");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Password is required.");

		loginpage.validateEnterPassword("H");

		Thread.sleep(6000);

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(loginpage.getPasswordProgressStatus(), "Very Weak");
		softAssert.assertEquals(loginpage.getPasswordStrengthText1Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText2Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		loginpage.validateEnterPassword("Ha");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(loginpage.getPasswordProgressStatus(), "Weak");
		softAssert.assertEquals(loginpage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText2Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		loginpage.validateEnterPassword("Ha1");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(loginpage.getPasswordProgressStatus(), "Strong");
		softAssert.assertEquals(loginpage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		loginpage.validateEnterPassword("Ha1@");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(loginpage.getPasswordProgressStatus(), "Very Strong");
		softAssert.assertEquals(loginpage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText3Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		loginpage.validateEnterPassword("Ha1@test");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Confirm password is required.");
		softAssert.assertEquals(loginpage.getPasswordProgressStatus(), "Excellent");
		softAssert.assertEquals(loginpage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText3Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(loginpage.getPasswordStrengthText4Style(), "rgba(4, 195, 0, 1)");

		loginpage.validateConfirmPassword("Ha1@");

		softAssert.assertEquals(loginpage.getTosterMessageText(), "New password and confirm password do not match.");

		loginpage.validateEnterPassword(prop.getProperty("password"));
		loginpage.validateConfirmPassword(prop.getProperty("password"));

		softAssert.assertEquals(loginpage.getTosterMessageText(), "Your password has been set successfully.");

		softAssert.assertAll();

	}

	//@Test(priority = 11)
	public void validateSetNewPasswordTest() throws InterruptedException {

		loginpage.validateForgotPasswordLink(prop.getProperty("ForgotMail"));

	}

	@Test(priority = 12)
	public void validateValidLoginTest() throws InterruptedException {

		homepage = loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homepage.validateHomePageTitle(), "Accordsign | Home", "Not navigated to Home page!");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
