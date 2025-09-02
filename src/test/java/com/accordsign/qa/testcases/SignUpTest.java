package com.accordsign.qa.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

	@Test
	public void validateSignupPageTitleTest() {

		String title = signuppage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Accordsign | Signup");
	}

	@Test
	public void validateSignUpPageHeadingTest() {

		String SignUpPageHeading = signuppage.validateSignUpPageHeading();
		Assert.assertEquals(SignUpPageHeading, "Create a free Account", "Heading Login is Mismatched");
	}

	@Test
	public void validateFirstNameLabelTest() {

		String FirstNameLabel = signuppage.validateFirstNameLabel();
		Assert.assertEquals(FirstNameLabel, "First Name", "First Name Label is Mismatched");

	}

	@Test
	public void validateLastNameLabelTest() {

		String LastNameLabel = signuppage.validateLastNameLabel();
		Assert.assertEquals(LastNameLabel, "Last Name", "Last Name Label is Mismatched");

	}

	@Test
	public void validateCompanyNameLabelTest() {

		String CompanyNameLabel = signuppage.validateCompanyNameLabel();
		Assert.assertEquals(CompanyNameLabel, "Company Name", "Company Name Label is Mismatched");

	}

	@Test
	public void validateWorkEmailLabelTest() {

		String WorkEmailLabel = signuppage.validateWorkEmailLabel();
		Assert.assertEquals(WorkEmailLabel, "Work Email Address", "Work Email Address Label is Mismatched");

	}

	@Test
	public void validatePhoneNumberLabelTest() {

		String PhoneNumberLabel = signuppage.validatePhoneNumberLabel();
		Assert.assertEquals(PhoneNumberLabel, "Phone Number", "Phone Number Label is Mismatched");

	}

	@Test
	public void validateFirstNamePlaceHolderTextTest() {

		String FirstNamePlaceHolderText = signuppage.validateFirstNamePlaceHolderText();
		Assert.assertEquals(FirstNamePlaceHolderText, "Enter first name", "First Name PlaceHolder is Mismatched");

	}

	@Test
	public void validateLastNamePlaceHolderTextTest() {

		String LastNamePlaceHolderText = signuppage.validateLastNamePlaceHolderText();
		Assert.assertEquals(LastNamePlaceHolderText, "Enter last name", "Last name PlaceHolder is Mismatched");

	}

	@Test
	public void validateCompanyNamePlaceHolderTextTest() {

		String CompanyNamePlaceHolderText = signuppage.validateCompanyNamePlaceHolderText();
		Assert.assertEquals(CompanyNamePlaceHolderText, "Enter company name",
				"Company Name PlaceHolder is Mismatched");

	}

	@Test
	public void validateWorkEmailPlaceHolderTextTest() {

		String WorkEmailPlaceHolderText = signuppage.validateWorkEmailPlaceHolderText();
		Assert.assertEquals(WorkEmailPlaceHolderText, "Enter Email ID",
				"Email Address PlaceHolder is Mismatched");

	}

	@Test
	public void validatePhoneNumberPlaceHolderTextTest() {

		String PhoneNumberPlaceHolderText = signuppage.validatePhoneNumberPlaceHolderText();
		Assert.assertEquals(PhoneNumberPlaceHolderText, "Enter phone number",
				"Phone Number PlaceHolder is Mismatched");

	}

	@Test
	public void validateSignupBtnTextTest() {

		String SignupBtnText = signuppage.validateSignupBtnText();
		Assert.assertEquals(SignupBtnText, "Create a free Account", "SignUp Button Text is Mismatched");

	}

	@Test
	public void validateCheckBoxTextTest() {

		String CheckBoxText = signuppage.validateCheckBoxText();
		Assert.assertEquals(CheckBoxText, "I consent to receive promotional and marketing emails",
				"Check Box Text is Mismatched");

	}

	// @Test
	public void validateSignupText1Test() {

		String SignupText1 = signuppage.validateSignupText1();
		Assert.assertEquals(SignupText1, "", " is Mismatched");

	}

	@Test
	public void validateSignupText2Test() {

		String SignupText2 = signuppage.validateSignupText2();
		Assert.assertEquals(SignupText2, "Already have an account? Login",
				"Already have an account? text is Mismatched");

	}

	//================================================Test cases Related to Functionality ==============================================//
	
    @Test
    public void validateSignUpValidationMessageTest() {
        // Click the SignUp button without filling details
    	signuppage.ClickSignUpLink();
    	
        // Get all toast messages
        List<String> actualToasts = signuppage.captureToastMessages();

        // Define expected messages
        List<String> expectedToasts = Arrays.asList(
            "Phone number is required.",
            "Company name is required.",
            "Last name is required.",
            "First name is required.",
            "Email is required."
        );

        // Validate (ignoring order)
        Assert.assertTrue(actualToasts.containsAll(expectedToasts) &&
                          expectedToasts.containsAll(actualToasts),
                "Toast messages did not match!");
    }
    
    
    @Test
    public void validateCountryCodeDropDownValue() throws InterruptedException {
    	
    	String region = signuppage.getSelectedRegionValue();
    	String selectedCountrycode = signuppage.getSelectedCountryCodeValue();
    	Assert.assertTrue(selectedCountrycode.contains(region),"Mismatch: Country Code '" + selectedCountrycode + "' is not part of Displayed Region  '" + region + "'");

    }
    
    
   // @Test
	public void validateUserSignUpTest() throws InterruptedException {

		homepage = signuppage.validateUserSignUp(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("CompanyName"), prop.getProperty("email"), prop.getProperty("PhoneNumber"),
				prop.getProperty("Password"));
		Assert.assertEquals(homepage.validateHomePageTitle(), "Accordsign | Home Page", "Not navigated to Home page!");

	}
	

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
