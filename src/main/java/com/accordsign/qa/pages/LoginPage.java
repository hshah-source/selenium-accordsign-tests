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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accordsign.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Constructor
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Page Factory - OR

	// Fields & Links

	@FindBy(id = "Email")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//input[@id='chkrememberme']")
	WebElement CheckBox;


	@FindBy(xpath = "//a[@id='btnLogin']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Accordsign Terms']")
	WebElement accordsignTermsLink;

	@FindBy(xpath = "//a[normalize-space()='Privacy Policy.']")
	WebElement PrivacyPolicyLink;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(id = "Password")
	WebElement PasswordMasked;
	

	// Images

	@FindBy(xpath = "//img[@class='digital-signature-logo']")
	WebElement DigitalSignatureLogo;

	@FindBy(xpath = "//img[@src='/img/accordsign-logo.svg']")
	WebElement AccordSignLogo;

	@FindBy(xpath = "//p[@class='default-color fw-bold']")
	WebElement CopyRight;

	@FindBy(xpath = "//img[@alt='Seeddata-logo']")
	WebElement SeedDataLogo;

	// Text

	@FindBy(xpath = "//h3[normalize-space()='Login']")
	WebElement LoginText;

	@FindBy(xpath = "//label[normalize-space()='Email ID']")
	WebElement EmailLabel;

	@FindBy(xpath = "//label[normalize-space()='Password']")
	WebElement PasswordLabel;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement EmailPlaceHolder;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement PasswordPlaceHolder;

	@FindBy(xpath = "//a[@id='btnLogin']")
	WebElement LoginBtnText;

	@FindBy(xpath = "//p[contains(text(),'I agree to the')]")
	WebElement LoginText1;  //T&C 1

	@FindBy(xpath = "//p[contains(text(),'Don’t have an account?')]")
	WebElement LoginText2; //T&C 2
	
	@FindBy(xpath = "//div[@class='toast-message']")
	List<WebElement> LoginValidationTosterMessage;
	
	
	
	
	
	
	
	
	// Forgot Password Link Flow Locators
	
	
	@FindBy(xpath = "//a[@id='forgotpassword']")
	WebElement Forgotpasswordlink;
	
	@FindBy(xpath = "//h3[normalize-space()='Forgot Password']")
	WebElement ForgotpasswordHeading;
	
	@FindBy(xpath = "//h5[normalize-space()='Please enter your Email to reset the password']")
	WebElement ForgotpasswordText;
	
	@FindBy(xpath = "//label[normalize-space()='Email ID']")
	WebElement ForgotpasswordEmailLabel;
	
	@FindBy(xpath = "//input[@id='AuthIdentity_EmailID']")
	WebElement ForgotPasswordEmail;
	
	@FindBy(xpath = "//a[@id='btnSubmit']")
	WebElement ForgotPasswordSubmitBtn;
	
	@FindBy(xpath = "//div[3]//p[1]")
	WebElement ForgotPasswordText1;
	
	@FindBy(xpath = "//p[contains(text(),'I agree to the')]")
	WebElement ForgotPasswordText2;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement ForgotPasswordValidationToster;
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//input[@id='txtOTP1']")
	WebElement EnterOTP;
	
	@FindBy(xpath = "//a[@id='btnVerifyOTP']")
	WebElement VerifyOTPBtn;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement NewPasswordField;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement ConfirmPasswordField;
	
	@FindBy(xpath = "//a[@id='btnSubmit']")
	WebElement UpdatePasswordBtn;
	
	
	
	
	// Actions Related to Text On Forgot Password Page.
	
	public void validateForgotPasswordLink() {
		
		Forgotpasswordlink.click();
		
	}
	
	public String validateForgotPasswordTitle() {
		
		return driver.getTitle();
	}
	
	public String validateForgotPasswordHeading() {
		
		return ForgotpasswordHeading.getText();
	}
	
	public String validateForgotPasswordText() {
		
		return ForgotpasswordText.getText();
	}
	
	public String validateForgotPasswordEmailLabel() {
		
		return ForgotpasswordEmailLabel.getText();
	}
	
	public String validateForgotPasswordPlaceHolder() {
		
		return ForgotPasswordEmail.getAttribute("placeholder");
	}
	
	public void validateForgotPasswordEmailTextBox(String email) {
		ForgotPasswordEmail.clear();
		ForgotPasswordEmail.sendKeys(email);
	}
	
	
	public String validateForgotPasswordSubmitbtn() {
		
		return ForgotPasswordSubmitBtn.getText();
	}
	
	public void validateForgotPasswordSubmit() {
		
		ForgotPasswordSubmitBtn.click();
	}
	
	public String validateForgotPasswordText1() {
		
		return ForgotPasswordText1.getText();
	}
	
	public String validateForgotPasswordText2() {
		
		return ForgotPasswordText2.getText();
	}
	
	public String validateForgotPasswordTosterMessage() throws InterruptedException {
		Thread.sleep(5000);
		return ForgotPasswordValidationToster.getText();
		
	}
	
	
	
	
	
	

	// Actions Related to Text On Login Page.

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public String validateLoginPageHeading() {
		return 	LoginText.getText();

	}

	public String validateEmailLabel() {

		return EmailLabel.getText();

	}

	public String validatePasswordLabel() {

		return PasswordLabel.getText();

	}

	public String validateEmailPlaceHolder() {

		return EmailPlaceHolder.getAttribute("placeholder");

	}

	public String validatePasswordPlaceHolder() {

		return PasswordPlaceHolder.getAttribute("placeholder");

	}

	public void validateEmailTextBox(String email) {
		EmailPlaceHolder.clear();
		 EmailPlaceHolder.sendKeys(email);

	}

	public void validatePasswordTextBox(String pwd) {
		PasswordPlaceHolder.clear();
		PasswordPlaceHolder.sendKeys(pwd);

	}

	public String validateLoginBtnText() {

		return LoginBtnText.getText();

	}

	public String validateSignUpText1() {
 
		return LoginText1.getText();

	}

	public String validateSignUpText2() {
 
		return LoginText2.getText();

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
	
	public void validateLoginBtn() {
		
		loginBtn.click();
	}
	
	

	// Actions Related to Functionality On Login Page.
	
	public SignUpPage validateSignUpLink() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(signUpLink));
	    signUpLink.click();
	    return new SignUpPage();
	}

	public boolean validateaccordSignTermsLink() {

		String initialUrl = driver.getCurrentUrl() + "#";
		System.out.println(initialUrl);
		accordsignTermsLink.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			// Wait for URL to change
			return wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
		} catch (TimeoutException e) {
			return false; // URL didn't change within timeout
		}

	}

	public boolean validatePrivacyPolicyLink() {

		String initialUrl = driver.getCurrentUrl() + "#";
		System.out.println(initialUrl);
		PrivacyPolicyLink.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			// Wait for URL to change
			return wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
		} catch (TimeoutException e) {
			return false; // URL didn't change within timeout
		}

	}

	
	public boolean PasswordMasked() {
		
		String PassowrdEyeIcon = PasswordMasked.getAttribute("type");
		return PassowrdEyeIcon.equalsIgnoreCase("Password");
		
	}
	
	public HomePage validateValidLogin(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();

	}

	// ==============================================Create New Page Class For
	// ForgotPassword
	// Functionality======================================================//

	public void validateForgotPasswordLink(String fp) throws InterruptedException {

		Forgotpasswordlink.click();
		ForgotPasswordEmail.sendKeys(fp);
		ForgotPasswordSubmitBtn.click();

		// Wait for OTP email to arrive
		try {
			Thread.sleep(10000); // wait 10 seconds (can increase if needed)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String otp = fetchOtpFromGmail();
		System.out.println("OTP: " + otp);

		EnterOTP.sendKeys(otp);
		VerifyOTPBtn.click();
		NewPasswordField.sendKeys("Harsh@123");
		ConfirmPasswordField.sendKeys("Harsh@123");
		Thread.sleep(2000);
		UpdatePasswordBtn.click();

	}
	
	
	
	
	// Validation messages check
	
	
	public List<String> captureToastMessages() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    // Wait until at least one toast message is visible
	    wait.until(ExpectedConditions.visibilityOfAllElements(LoginValidationTosterMessage));

	    List<String> toastTexts = new ArrayList<>();
	    for (WebElement toast : LoginValidationTosterMessage) {
	        toastTexts.add(toast.getText().trim());
	    }
	    return toastTexts;
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

				if (subject != null && subject.contains("Accordsign : Reset Password")) {
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
