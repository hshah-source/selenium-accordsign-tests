package com.accordsign.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accordsign.qa.base.TestBase;

public class SignUpPage extends TestBase {

	// Constructor
	public SignUpPage() {

		PageFactory.initElements(driver, this);

	}

	// Page Factory - OR

	// =========================================Locators for Text & Label
	// =======================================================//
	
	
	@FindBy(css = "#toast-container .toast-message")
	List<WebElement> SignUpValidationMessageList;

	@FindBy(xpath = "//h3[normalize-space()='Create a free Account']")
	WebElement SignUpPageHeadingText;

	@FindBy(xpath = "//label[normalize-space()='First Name']")
	WebElement FirstNameLabel;

	@FindBy(xpath = "//label[normalize-space()='Last Name']")
	WebElement LastNameLabel;

	@FindBy(xpath = "//label[normalize-space()='Company Name']")
	WebElement CompanyNameLabel;

	@FindBy(xpath = "//label[normalize-space()='Work Email Address']")
	WebElement WorkEmailLabel;

	@FindBy(xpath = "//label[normalize-space()='Phone Number']")
	WebElement PhoneNumberLabel;

	@FindBy(xpath = "//a[@id='btnSignup']")
	WebElement SignupBtnText;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_FirstName']")
	WebElement FirstNamePlaceHolderText;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_LastName']")
	WebElement LastNamePlaceHolderText;

	@FindBy(xpath = "//input[@id='AuthIdentity_Account_BusinessName']")
	WebElement CompanyNamePlaceHolderText;

	@FindBy(xpath = "//input[@id='AuthIdentity_EmailID']")
	WebElement WorkEmailPlaceHolderText;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_PhoneNumber']")
	WebElement PhoneNumberPlaceHolderText;

	@FindBy(xpath = "//label[contains(text(),'I consent to receive promotional and marketing ema')]")
	WebElement CheckBoxText;

	@FindBy(xpath = "//p[contains(text(),'I agree to the')]")
	WebElement SignupText1;

	@FindBy(xpath = "//div[@class='form-group account']//p[@class='default-color']")
	WebElement SignupText2;

	// ==========================================Locators For
	// Images=======================================================================//

	@FindBy(xpath = "//img[@class='digital-signature-logo']")
	WebElement DigitalSignatureLogo;

	@FindBy(xpath = "//img[@src='/img/accordsign-logo.svg']")
	WebElement AccordSignLogo;

	@FindBy(xpath = "//p[@class='default-color fw-bold']")
	WebElement CopyRight;

	@FindBy(xpath = "//img[@alt='Seeddata-logo']")
	WebElement SeedDataLogo;

	// ===========================================Locators for
	// Functionality=================================================//

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement SignUpLink;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_FirstName']")
	WebElement Contact_FirstName;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_LastName']")
	WebElement Contact_LastName;

	@FindBy(xpath = "//input[@id='AuthIdentity_Account_BusinessName']")
	WebElement Contact_CompanyName;

	@FindBy(xpath = "//input[@id='AuthIdentity_EmailID']")
	WebElement Contact_EmailID;

	@FindBy(xpath = "//input[@id='AuthIdentity_Contact_PhoneNumber']")
	WebElement Contact_PhoneNumber;

	@FindBy(xpath = "//input[@id='chkSendPromotionalMail']")
	WebElement Contact_CheckBox;

	@FindBy(xpath = "//a[@id='btnSignup']")
	WebElement SignUpBtn;

	@FindBy(xpath = "//input[@id='txtOTP1']")
	WebElement EnterOTP;

	@FindBy(xpath = "//a[@id='btnVerifyOTP']")
	WebElement VerifyOTPBtn;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement EnterPassword;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//a[@id='btnSubmit']")
	WebElement CreatePasswordBtn;

	@FindBy(id = "spanRegionName")
	WebElement Region;
	
	@FindBy(xpath = "//ul[@id='iti-0__country-listbox']")
	List<WebElement> countryCodeList;
	
	@FindBy(xpath = "//div[@class='iti__selected-flag']")
	WebElement SelectedCountryCodeValue;

	// =============================================Actions Related to Text &
	// Label===============================================================//
	
	
	
	

	public String validateSignUpPageTitle() {

		return driver.getTitle();
	}

	public String validateSignUpPageHeading() {

		String signupHeading = SignUpPageHeadingText.getText();
		return signupHeading;
	}

	public String validateFirstNameLabel() {

		String firstnamelabel = FirstNameLabel.getText();
		return firstnamelabel;
	}

	public String validateLastNameLabel() {

		String lastnamelabel = LastNameLabel.getText();
		return lastnamelabel;
	}

	public String validateCompanyNameLabel() {

		String companynamelabel = CompanyNameLabel.getText();
		return companynamelabel;
	}

	public String validateWorkEmailLabel() {

		String workemaillabel = WorkEmailLabel.getText();
		return workemaillabel;
	}

	public String validatePhoneNumberLabel() {

		String phonenumberlabel = PhoneNumberLabel.getText();
		return phonenumberlabel;
	}

	public String validateSignupBtnText() {

		String signupbtntext = SignupBtnText.getText();
		return signupbtntext;
	}

	public String validateFirstNamePlaceHolderText() {

		String firstnameplaceholdertext = FirstNamePlaceHolderText.getAttribute("placeholder");
		return firstnameplaceholdertext;
	}

	public String validateLastNamePlaceHolderText() {

		String lastnameplaceholdertext = LastNamePlaceHolderText.getAttribute("placeholder");
		return lastnameplaceholdertext;
	}

	public String validateCompanyNamePlaceHolderText() {

		String companynameplaceholdertext = CompanyNamePlaceHolderText.getAttribute("placeholder");
		return companynameplaceholdertext;
	}

	public String validateWorkEmailPlaceHolderText() {

		String workemailplaceholdertext = WorkEmailPlaceHolderText.getAttribute("placeholder");
		return workemailplaceholdertext;
	}

	public String validatePhoneNumberPlaceHolderText() {

		String phonenumberplaceholdertext = PhoneNumberPlaceHolderText.getAttribute("placeholder");
		return phonenumberplaceholdertext;
	}

	public String validateCheckBoxText() {

		String checkboxtext = CheckBoxText.getText();
		return checkboxtext;
	}

	public String validateSignupText1() {

		String signuptext1 = SignupText1.getText();
		return signuptext1;
	}

	public String validateSignupText2() {

		String signuptext2 = SignupText2.getText();
		return signuptext2;
	}

	// Actions Related to Image On Login Page.

	public boolean validateDigitalSignatureLogoDisplayed() {

		return DigitalSignatureLogo.isDisplayed();

	}

	public boolean validateAccordSignLogoDisplayed() {

		return AccordSignLogo.isDisplayed();

	}

	public boolean validateCopyRightDisplayed() {

		return CopyRight.isDisplayed();

	}

	public boolean validateSeedDataLogoDisplayed() {

		return SeedDataLogo.isDisplayed();

	}

	// ===============================================Actions Related to
	// Functionality======================================================//
	
	
	
	
	public void openCountryCodeDropDown() throws InterruptedException {
		
		Thread.sleep(2000);
		SelectedCountryCodeValue.click();
		
	}
	
	public String getSelectedRegionValue() throws InterruptedException {
		
		Thread.sleep(2000);
		String regionValue = Region.getText();
		return regionValue;
		//System.out.println("regionValue = " + regionValue);
	}
	
	public String getSelectedCountryCodeValue() throws InterruptedException {
		
		Thread.sleep(2000);
		
		String selectedCountry = SelectedCountryCodeValue.getAttribute("title");
		//System.out.println("Selected Country = " + selectedCountry);
		return selectedCountry;
	}
	
	
	
//	public void selectCountryByName(String countryName) {
//		
//		
//		for (WebElement country : countryCodeList) {
//            String name = country.findElement(org.openqa.selenium.By.cssSelector(".iti__country-name")).getText();
//            
//            if (name.equalsIgnoreCase(countryName)) {
//                country.click();
//                break;
//            }
//        }
//		
//	}
	
	
	
	public void ClickSignUpLink() {
		
		
		//Contact_FirstName.sendKeys("Harsh");
		//Contact_LastName.sendKeys(lastName);
		//Contact_CompanyName.sendKeys(companyName);
		//Contact_EmailID.sendKeys(email);
		//Contact_PhoneNumber.sendKeys(contactNumber);
		//Contact_CheckBox.click();
		
		SignUpBtn.click();
	}
	

	public List<String> captureToastMessages() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    // Wait until at least one toast message is visible
	    wait.until(ExpectedConditions.visibilityOfAllElements(SignUpValidationMessageList));

	    List<String> toastTexts = new ArrayList<>();
	    for (WebElement toast : SignUpValidationMessageList) {
	        toastTexts.add(toast.getText().trim());
	    }
	    return toastTexts;
	}

	public HomePage validateUserSignUp(String firstName, String lastName, String companyName, String email,
			String contactNumber, String password) {

		Contact_FirstName.sendKeys(firstName);
		Contact_LastName.sendKeys(lastName);
		Contact_CompanyName.sendKeys(companyName);
		Contact_EmailID.sendKeys(email);
		Contact_PhoneNumber.sendKeys(contactNumber);
		Contact_CheckBox.click();
		SignUpBtn.click();

		// Wait for OTP email to arrive
		try {
			Thread.sleep(15000); // wait 10 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String otp = fetchOtpFromGmail();
		// System.out.println("OTP: " + otp);

		EnterOTP.sendKeys(otp);
		VerifyOTPBtn.click();

		EnterPassword.sendKeys(password);
		ConfirmPassword.sendKeys(password);
		CreatePasswordBtn.click();

		return new HomePage();
	}

	// Featch OTP Methods

	public String fetchOtpFromGmail() {
		String host = "imap.gmail.com";
		String username = "hshah@perigeon.com"; // Replace with your Gmail
		String password = "clay rycx jhgn mard"; // Replace with your App Password

		try {
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.ssl.enable", "true");

			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imap");
			store.connect(host, username, password);

			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);

			Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i];
				String subject = message.getSubject();

				if (subject != null && subject.contains("Accordsign: Account Registration - OTP")) {
					String content = getTextFromMessage(message);

					// Debug output (optional)
					// System.out.println("Subject: " + subject);
					// System.out.println("Content:\n" + content);

					// Extract OTP using Jsoup
					String otp = extractOTP(content);
					if (otp != null) {
						message.setFlag(Flags.Flag.SEEN, true); // Mark as read
						inbox.close(false);
						store.close();
						return otp;
					}
				}
			}

			inbox.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String getTextFromMessage(Message message) throws MessagingException, IOException {
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString();
		} else if (message.isMimeType("text/html")) {
			return message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			return getTextFromMimeMultipart(mimeMultipart);

		}
		return "";
	}

	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		StringBuilder result = new StringBuilder();
		int count = mimeMultipart.getCount();

		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result.append(bodyPart.getContent());
			} else if (bodyPart.isMimeType("text/html")) {
				result.append(bodyPart.getContent());
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
			}
		}
		return result.toString();

	}

	public static String extractOTP(String htmlContent) {
		Document doc = Jsoup.parse(htmlContent);

		// Select span with "font-weight: bold" in its style
		Element otpElement = doc.selectFirst("span[style*=font-weight: bold]");
		if (otpElement != null) {
			String otp = otpElement.text().trim();
			return otp;

		} else {
			System.out.println("OTP not found");
			return null;
		}

	}

}
