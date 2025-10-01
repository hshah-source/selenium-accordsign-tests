package com.accordsign.qa.pages;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accordsign.qa.base.TestBase;

public class HomePage extends TestBase{

	// Constructor
		public HomePage() {

			PageFactory.initElements(driver, this);
			
		}
	
		// Page Factory - OR
		
		
		//Get Started PopUp Locators
		
		@FindBy(xpath = "//a[@id='btnFirstTimeLogin']")
		WebElement GetStartedPopupBtn;
		
		@FindBy(xpath = "//img[@alt='start with document']")
		WebElement GetStartedImage1;
		
		@FindBy(xpath = "//img[@alt='Get Signature']")
		WebElement GetStartedImage2;
		
		@FindBy(xpath = "//img[@alt='Keep it All in One Place']")
		WebElement GetStartedImage3;
		
		@FindBy(xpath = "//h1[normalize-space()='Start with Document']")
		WebElement GetStartedTitle1;
		
		@FindBy(xpath = "//h1[normalize-space()='Get Signature']")
		WebElement GetStartedTitle2;
		
		@FindBy(xpath = "//h1[normalize-space()='Keep it All in One Place']")
		WebElement GetStartedTitle3;
		
		@FindBy(xpath = "//p[@class='popup-sub-title'][contains(text(),'Upload Pdf, Word, Excel, and More From Your Comput')]")
		WebElement GetStartedText1;
		
		@FindBy(xpath = "//p[contains(text(),'Place Field on Your Document To Guide Recipients W')]")
		WebElement GetStartedText2;
		
		@FindBy(xpath = "//p[contains(text(),'Track and Organize Your Document to Get Business D')]")
		WebElement GetStartedText3;
		

		//Setting Menu Locators
		@FindBy(xpath = "//a[@id='liSettings']")
		WebElement SettingMenuBtn;
		
		@FindBy(xpath = "//ul[@class='nav-list-inner ps-0 setting-sub-list']")
		WebElement SettingMenuDD;
		
		@FindBy(xpath = "//ul[@class='nav-list-inner ps-0 setting-sub-list']//li")
		List<WebElement> SettingMenuList;
		
		
		// Setting Menu Profile Page Locators
		@FindBy(xpath = "//a[@id='hrefProfile']")
		WebElement Profile;
		
	
		// Setting Menu Security Page Locators
		@FindBy(xpath = "//a[@id='hrefChangePassword']")
		WebElement Security;
		
		
		// Setting Menu Login Methods Page Locators
		@FindBy(xpath = "//a[@id='hrefLoginMethods']")
		WebElement LoginMethods;
		
		
		// Setting Menu My Signatures Page Locators
		@FindBy(xpath = "//span[normalize-space()='My Signatures']")
		WebElement MySignatures;
		
		
		// Setting Menu Business Profile Page Locators
		@FindBy(xpath = "//span[normalize-space()='Business Profile']")
		WebElement BusinessProfile;
		
		
		// Home Page Elements Locators
		@FindBy(xpath = "//img[@alt='accordsign_logo']")
		WebElement HomePageLogo;
		
		@FindBy(xpath = "//button[@class='btn primary-button mb-3 d-flex align-items-center gap-2 waves-effect waves-light']")
		WebElement CreateNewBtn;
		
		
		

		
		//GetStarted Popup Actions
		
		public WebElement validateGetStartedPopupImage1() {
			
			return GetStartedImage1;
		}
		
		public WebElement validateGetStartedPopupImage2() {
			
			return GetStartedImage2;
		}
		
		public WebElement validateGetStartedPopupImage3() {
			
			return GetStartedImage3;
		}
		
		public String validateGetStartedPopupTitle1() {
			
			return GetStartedTitle1.getText();
			
		}
		public String validateGetStartedPopupTitle2() {
			
			return GetStartedTitle2.getText();
		}
		public String validateGetStartedPopupTitle3() {
			
			return GetStartedTitle3.getText();
		}
		
		public String validateGetStartedPopupText1() {
			
			return GetStartedText1.getText();
			
		}
		
		public String validateGetStartedPopupText2() {

			return GetStartedText2.getText();

		}

		public String validateGetStartedPopupText3() {

			return GetStartedText3.getText();

		}
		
		
		public void validateGetStartedPopupBtn() throws InterruptedException {
			
			Thread.sleep(2000);
			GetStartedPopupBtn.click();
		}
		

		
		// Home page Navigation Menu Actions
		
		public String validateSettingMenuStatus() throws InterruptedException {
			
			Thread.sleep(2000);
			return SettingMenuDD.getAttribute("style");
			
		}
		
		public List<String> validateSettingMenuItems() {
			
			SettingMenuBtn.click();			
			List<String> menuItems = new ArrayList<>();
	        for (WebElement item : SettingMenuList) {
	            menuItems.add(item.getText().trim());
	        }
	        return menuItems;
			
		}
		
		
		// Profile Page Action Return Object 
		
		public String validateMySettingProfileLinkSelected() {
			
			SettingMenuBtn.click();
			Profile.click();
			return Profile.getAttribute("class");
			
		}
		public ProfilePage validateMySettingProfileLink() throws InterruptedException {
			
			SettingMenuBtn.click();
			Profile.click();
			Thread.sleep(5000);
			return new ProfilePage();
			
		}
	
		// Security Page Action Return Object
		
		public String validateMySettingSecurityLinkSelected() {
			
			SettingMenuBtn.click();
			Security.click();
			return Security.getAttribute("class");
			
		}
		public SecurityPage validateMySettingSecurityLink() {
			
			SettingMenuBtn.click();
			Security.click();
			return new SecurityPage();
		}
		
		// Login Methods Page Action Return Object
		
		public String validateMySettingLoginMethodsLinkSelected() {
			
			SettingMenuBtn.click();
			LoginMethods.click();
			return LoginMethods.getAttribute("class");
			
		}
		public LoginMethodsPage validateMySettingLoginMethodsLink() {
			
			SettingMenuBtn.click();
			LoginMethods.click();
			return new LoginMethodsPage();
			
		}
		
		// MySignatures Page Action Return Object
		
		public String validateMySettingMySignaturesLinkSelected() {
			
			SettingMenuBtn.click();
			MySignatures.click();
			return MySignatures.getAttribute("class");
			
		}
		public MySignaturesPage validateMySettingMySignaturesLink() {
			
			SettingMenuBtn.click();
			MySignatures.click();
			return new MySignaturesPage();
			
		}
		
		// BusinessProfile Page Action Return Object
		
		public String validateMySettingBusinessProfileLinkSelected() {
			
			SettingMenuBtn.click();
			BusinessProfile.click();
			return BusinessProfile.getAttribute("class");
			
		}
		public BusinessProfilePage validateMySettingBusinessProfileLink() {
			
			SettingMenuBtn.click();
			BusinessProfile.click();
			return new BusinessProfilePage();
			
		}
		
		
		
		
		
		// Home Page Actions
		
		public String validateHomePageTitle() throws InterruptedException {
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Images Validation Method Get Started PopUp
		// Method to validate single image
		public boolean isImageValid(WebElement element) {
		    try {
		        String imageUrl = element.getAttribute("src");
		        URI uri = URI.create(imageUrl); // Create a URI safely
		        URL url = uri.toURL(); // Convert to URL

		        HttpURLConnection http = (HttpURLConnection) url.openConnection();
		        http.setConnectTimeout(5000);
		        http.connect();

		        int statusCode = http.getResponseCode();
		        return statusCode == 200;
		    } catch (Exception e) {
		        return false;
		    }
		}
		
		
		
}
