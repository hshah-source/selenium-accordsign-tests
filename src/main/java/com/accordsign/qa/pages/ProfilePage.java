package com.accordsign.qa.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.accordsign.qa.base.TestBase;

public class ProfilePage extends TestBase{

	
		// Constructor
		public ProfilePage() {

			PageFactory.initElements(driver, this);

		}
		
		
		// Profile Page Locators
		
		@FindBy(xpath = "//h4[normalize-space()='Profile']")
		WebElement ProfilePageHeading;
		
		@FindBy(xpath = "//label[normalize-space()='First Name']")
		WebElement FirstNameLabel;
		
		@FindBy(xpath = "//input[@id='AuthIdentity_Contact_FirstName']")
		WebElement FirstNamePlaceHolder;
		
		@FindBy(xpath = "//label[normalize-space()='Last Name']")
		WebElement LastNameLabel;
		
		@FindBy(xpath = "//input[@id='AuthIdentity_Contact_LastName']")
		WebElement LastNamePlaceHolder;
		
		@FindBy(xpath = "//label[normalize-space()='Phone Number']")
		WebElement PhoneNumberLabel;
		
		@FindBy(xpath = "//input[@id='AuthIdentity_Contact_PhoneNumber']")
		WebElement PhoneNumberPlaceHolder;
		
		@FindBy(xpath = "//label[normalize-space()='Work Email Address']")
		WebElement EmailLabel;
		
		@FindBy(xpath = "//label[normalize-space()='Region']")
		WebElement RegionLabel;
		
		@FindBy(xpath = "//label[normalize-space()='Timezone']")
		WebElement TimeZoneLabel;
		
		@FindBy(id = "business-convert-button")
		WebElement selectImageBtn;
		
		@FindBy(xpath = "//button[@id='add-new-signature']")
		WebElement RemoveBtn;
		
		@FindBy(xpath = "//a[@id='btnUpdate']")
		WebElement UpdateBtn;
		
		@FindBy(css = "img.cropit-preview-image")
		WebElement previewImage;
		
		@FindBy(xpath = "//div[@class='toast-message']")
		WebElement ValidationToster;
		
		@FindBy(xpath = "//p[@id='deleteAccount']")
		WebElement DeleteAccountLink;
		
		@FindBy(css = ".modal-content")
		WebElement DeleteAccountPopUp;
		
		@FindBy(id = "deleteAccountModalLabel")
		WebElement DeleteAccountPopUpTitle;
		
		@FindBy(css = ".modal-body")
		WebElement DeleteAccountPopUpBody;
		
		@FindBy(css = ".cancel-button")
		WebElement DeleteAccountPopUpCancelBtn;
		
		@FindBy(id = "confirmDeleteButton")
		WebElement DeleteAccountPopUpOkBtn;
		
		@FindBy(xpath = "//button[@class='btn-close close-style']")
		WebElement DeleteAccountPopUpClose;
		
		
		
		
		
		
		//Profile Page Images
	
		public String validateProfilePageTitle() throws InterruptedException {
			
			return driver.getTitle();
		}
		
		public String validateProfilePageHeading() {
			
			return ProfilePageHeading.getText();
			
		}
		
		
		public String validateFirstNameLabel() {
			
			return FirstNameLabel.getText();
			
		}
		
		public String validateFirstNamePlaceHolder() {
			
			FirstNamePlaceHolder.clear();
			return FirstNamePlaceHolder.getAttribute("PlaceHolder");
		}
		
		public String validateLastNameLebel() {
			
			return LastNameLabel.getText();
		}
		
		public String validateLasttNamePlaceHolder() {
			LastNamePlaceHolder.clear();
			return LastNamePlaceHolder.getAttribute("PlaceHolder");
		}
		public String validatePhoneNumberLebel() {
			
			return PhoneNumberLabel.getText();
		}
		
		public String validatePhoneNumberPlaceHolder() {
			
			PhoneNumberPlaceHolder.clear();
			return PhoneNumberPlaceHolder.getAttribute("PlaceHolder");
		}		
		
		public String validateEmailLabel() {
			
			return EmailLabel.getText();
		}
		public String validateRegionLabel() {
	
			return RegionLabel.getText();
		}
		public String validateTimeZoneLabel() {
	
			return TimeZoneLabel.getText();
		}
		
		public String validateSelectImageBtnText() {
			
			return selectImageBtn.getText();
		}
		
		public String validateRemoveBtnText() {
			
			return RemoveBtn.getText();
		}
		
		public String validateUpdateBtnText() {
			
			return UpdateBtn.getText();
		}
		
		
		
		public String validateUpdateBtnValidation() throws InterruptedException {
			
			PhoneNumberPlaceHolder.clear();
			PhoneNumberPlaceHolder.sendKeys("9824291881");
			Thread.sleep(2000);
			UpdateBtn.click();
			return ValidationToster.getText();
			
		}
		
		
		public void validateDeleteAccountLink(){
			
			DeleteAccountLink.click();
		}
		
		
		public boolean validatedeletePopup() {
			
			
	    	wait.until(ExpectedConditions.visibilityOfAllElements(DeleteAccountPopUp));
			return DeleteAccountPopUp.isDisplayed();
			
		}
		
		public String validateDeletePopupTitle() {
			
			return DeleteAccountPopUpTitle.getText().trim();
			
		}
		
		public boolean validateDeletePopupBody() {
			
			return DeleteAccountPopUpBody.getText().contains("Deleting your account is not reversible.");
		}
		
		public String validateDeletePopupCancelBtn() {
			
			return DeleteAccountPopUpCancelBtn.getText();
		}
		
		public String validateDeletePopupOkBtn() {
			
			return DeleteAccountPopUpOkBtn.getText();
		}
		
		public boolean validatedeletePopupdisappear() {
			
			DeleteAccountPopUpClose.click();
			return wait.until(ExpectedConditions.invisibilityOf(DeleteAccountPopUp));
		
			
		}
		
		

		
		
		 // Upload image using Robot (for OS dialog)
	    public void uploadImageWithRobot(String imagePath) throws Exception {
	        selectImageBtn.click();
	        Thread.sleep(2000);

	        // Copy path to clipboard
	        StringSelection ss = new StringSelection(imagePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	        // Paste & Enter
	        Robot robot = new Robot();
	        robot.delay(1000);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	     // Wait until src starts with "data:image"
	        wait.until(driver -> previewImage.getAttribute("src") != null 
	                            && previewImage.getAttribute("src").startsWith("data:image"));
	    }
	    
	    
	    public boolean removeProfileImage() {
	        RemoveBtn.click();
	        try {
	            return wait.until(ExpectedConditions.invisibilityOf(previewImage));
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    
	    
	    public boolean ProfileImageIsDisplayed() {
	    	
	    	 wait.until(ExpectedConditions.visibilityOfAllElements(previewImage));
	        try {
	            String srcValue = previewImage.getAttribute("src");
	            return previewImage.isDisplayed() && srcValue != null && srcValue.startsWith("data:image");
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
		

	
}
