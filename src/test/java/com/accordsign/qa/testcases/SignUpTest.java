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
import com.accordsign.qa.pages.SignUpPage;

public class SignUpTest extends TestBase {

	SignUpPage signuppage;
	HomePage homepage;
	LoginPage loginpage;

	public SignUpTest() {

		super();
	}

	@BeforeMethod
	public void SetUp() {

		initialization();
		loginpage = new LoginPage();
		signuppage = loginpage.validateSignUpLink();

	}

	// =========================================================TestCases Related To
	// Text & Label =================================================//

	@Test(priority = 1)
	public void validateSignupPageTitleTest() {

		String title = signuppage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Accordsign | Signup");
	}

	@Test(priority = 2)
	public void validateAllElementsOnSignupPage() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		softAssert.assertEquals(signuppage.validateSignUpPageHeading(), "Create a free Account");

		softAssert.assertEquals(signuppage.validateFirstNameLabel(), "First Name");

		softAssert.assertEquals(signuppage.validateFirstNamePlaceHolderText(), "Enter first name");

		softAssert.assertEquals(signuppage.validateLastNameLabel(), "Last Name");

		softAssert.assertEquals(signuppage.validateLastNamePlaceHolderText(), "Enter last name");

		softAssert.assertEquals(signuppage.validateCompanyNameLabel(), "Company Name");

		softAssert.assertEquals(signuppage.validateCompanyNamePlaceHolderText(), "Enter company name");

		softAssert.assertEquals(signuppage.validateWorkEmailLabel(), "Work Email Address");

		softAssert.assertEquals(signuppage.validateWorkEmailPlaceHolderText(), "Enter Email ID");

		softAssert.assertEquals(signuppage.validatePhoneNumberLabel(), "Phone Number");

		softAssert.assertEquals(signuppage.validatePhoneNumberPlaceHolderText(), "Enter phone number");

		softAssert.assertEquals(signuppage.validateCheckBoxText(),
				"I consent to receive promotional and marketing emails");

		softAssert.assertEquals(signuppage.validateSignupBtnText(), "Create a free Account");

		softAssert.assertEquals(signuppage.validateSignupText1(),
				"I agree to the Accordsign Terms and acknowledge how my data is used and protected as outlined in the Privacy Policy.");

		softAssert.assertEquals(signuppage.validateSignupText2(), "Already have an account? Login");

		softAssert.assertAll();

	}

	// ================================================ Test cases Related to
	// Functionality ==============================================//

	@Test(priority = 3)
	public void validateSignUpValidationMessageTest() {
		// Click the SignUp button without filling details
		signuppage.ClickSignUpBtn();

		// Get all toast messages
		List<String> actualToasts = signuppage.captureToastMessages();

		// Define expected messages
		List<String> expectedToasts = Arrays.asList("Phone number is required.", "Company name is required.",
				"Last name is required.", "First name is required.", "Email is required.");

		// Validate (ignoring order)
		Assert.assertTrue(actualToasts.containsAll(expectedToasts) && expectedToasts.containsAll(actualToasts),
				"Toast messages did not match!");
	}

	@Test(priority = 4)
	public void validateCountryCodeDropDownValue() throws InterruptedException {

		String region = signuppage.getSelectedRegionValue();
		String selectedCountrycode = signuppage.getSelectedCountryCodeValue();
		Assert.assertTrue(selectedCountrycode.contains(region), "Mismatch: Country Code '" + selectedCountrycode
				+ "' is not part of Displayed Region  '" + region + "'");

	}

	//@Test(priority = 5)
	public void validateSignupOtpPageAllElement() throws InterruptedException {

		signuppage.validateOTPPageDetails(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("CompanyName"), prop.getProperty("email"), prop.getProperty("PhoneNumber"),
				prop.getProperty("Password"));

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		String email = prop.getProperty("email");
		softAssert.assertEquals(signuppage.getOTPPageTitle(), "Accordsign | OTP");
		softAssert.assertEquals(signuppage.getOTPHeadingText(), "Check Your Email");
		softAssert.assertEquals(signuppage.getSentOTPMessage(), "We have sent an OTP to : hshah@perigeon.com");
		softAssert.assertTrue(signuppage.getSentOTPEmail().contains(email));
		softAssert.assertEquals(signuppage.getOTPInstructionText(),
				"Check your inbox & follow the instructions to get started.");

		signuppage.validateSubmitOTPBtn();

		softAssert.assertEquals(signuppage.getOTPValidationMessage(), "Please enter the OTP.");

		Thread.sleep(4000);

		signuppage.enterInvalidOTP();

		signuppage.validateSubmitOTPBtn();

		Thread.sleep(4000);

		softAssert.assertEquals(signuppage.getOTPValidationMessage(), "That OTP doesn’t look right. Please try again.");

		signuppage.clickResendLink();

		softAssert.assertEquals(signuppage.getOTPResendSuccessMessage(), "OTP sent successfully!");

		Thread.sleep(4000);

		softAssert.assertEquals(signuppage.isResendTextDisplayed(), "Didn’t Receive OTP? Resend");

		softAssert.assertEquals(signuppage.isLoginLinkDisplayed(), "Already have an account? Login");

		softAssert.assertAll(); // This will report all failures together

	}

	//@Test(priority = 6)
	public void validateSignupPasswordPageAllElement() throws InterruptedException {

		signuppage.validateSetPasswordPageDetails(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("CompanyName"), prop.getProperty("email"), prop.getProperty("PhoneNumber"),
				prop.getProperty("Password"));

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);

		softAssert.assertEquals(signuppage.getPasswordPageTitle(), "AccordSign | Set Password");

		softAssert.assertEquals(signuppage.getPasswordHeadingText(), "Set a New Password");

		softAssert.assertEquals(signuppage.getPasswordlabelText(), "Password");

		softAssert.assertEquals(signuppage.getPasswordPlaceholderText(), "Enter password");

		softAssert.assertEquals(signuppage.getConfirmPasswordlabelText(), "Confirm Password");

		softAssert.assertEquals(signuppage.getConfirmPasswordPlaceholderText(), "Confirm password");

		softAssert.assertEquals(signuppage.getPasswordProgressText(), "Password Strength:");

		softAssert.assertEquals(signuppage.getPasswordStrengthText1(), " Atleast 1 Lowercase & 1 Uppercase");

		softAssert.assertEquals(signuppage.getPasswordStrengthText2(), " Atleast 1 Number (0-9)");

		softAssert.assertEquals(signuppage.getPasswordStrengthText3(), " Atleast 1 Special Character (!@#$%&*)");

		softAssert.assertEquals(signuppage.getPasswordStrengthText4(), " Minium 8 & Maximum 15 Characters");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Password is required.");

		signuppage.validateEnterPassword("H");

		Thread.sleep(6000);

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(signuppage.getPasswordProgressStatus(), "Very Weak");
		softAssert.assertEquals(signuppage.getPasswordStrengthText1Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText2Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		signuppage.validateEnterPassword("Ha");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(signuppage.getPasswordProgressStatus(), "Weak");
		softAssert.assertEquals(signuppage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText2Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		signuppage.validateEnterPassword("Ha1");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(signuppage.getPasswordProgressStatus(), "Strong");
		softAssert.assertEquals(signuppage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText3Style(), "rgba(128, 128, 128, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		signuppage.validateEnterPassword("Ha1@");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Password doesn’t meet our security policy.");
		softAssert.assertEquals(signuppage.getPasswordProgressStatus(), "Very Strong");
		softAssert.assertEquals(signuppage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText3Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText4Style(), "rgba(128, 128, 128, 1)");

		signuppage.validateEnterPassword("Ha1@test");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "Confirm password is required.");
		softAssert.assertEquals(signuppage.getPasswordProgressStatus(), "Excellent");
		softAssert.assertEquals(signuppage.getPasswordStrengthText1Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText2Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText3Style(), "rgba(4, 195, 0, 1)");
		softAssert.assertEquals(signuppage.getPasswordStrengthText4Style(), "rgba(4, 195, 0, 1)");

		signuppage.validateConfirmPassword("Ha1@");

		softAssert.assertEquals(signuppage.getTosterMessageText(), "New password and confirm password do not match.");

		softAssert.assertAll();

	}

	//@Test(priority = 7)
	public void validateUserSignUpTest() throws InterruptedException {

		homepage = signuppage.validateUserSignUp(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("CompanyName"), prop.getProperty("email"), prop.getProperty("PhoneNumber"),
				prop.getProperty("Password"));
		Assert.assertEquals(homepage.validateHomePageTitle(), "Accordsign | Home", "Not navigated to Home page!");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
