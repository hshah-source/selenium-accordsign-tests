package com.accordsign.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.accordsign.qa.base.TestBase;

public class MySignaturesPage extends TestBase {

	// Constructor
	public MySignaturesPage() {

		PageFactory.initElements(driver, this);

	}

	//  MySignature Page Locators

	@FindBy(xpath = "//h4[1]")
	WebElement MySignatureHeading;
	
	@FindBy(xpath = "//button[@id='btnNewSignatureFormat']")
	WebElement CreateSignatureBtn;

	@FindBy(xpath = "//p[@class='create-signature-title-text']")
	WebElement NoSignatureText1;
	
	@FindBy(xpath = "//p[@class='create-signature-subtitle-text']")
	WebElement NoSignatureText2;
	
	
	// Create your signature popup Elements
	
	
	@FindBy(xpath = "//div[@id='signatureFormatModal']//div[@class='modal-content']")
	WebElement CreateSignaturePopup;
	
	@FindBy(xpath = "//h5[@id='signatureFormatModalLabel']")
	WebElement CreateSignaturePopupHeading;
	
	@FindBy(xpath = "//ul[@class='create-signature-canvas-top-section']//li[1]")
	WebElement CreateSignaturePopupChooseBtn;
	
	@FindBy(xpath = "//ul[@class='create-signature-canvas-top-section']//li[2]")
	WebElement CreateSignaturePopupDrawBtn;
	
	@FindBy(xpath = "//ul[@class='create-signature-canvas-top-section']//li[3]")
	WebElement CreateSignaturePopupUploadBtn;
	
	@FindBy(xpath = "//a[@id='btnCancelSignatureFormat']")
	WebElement CreateSignaturePopupUpCancelBtn;
	
	@FindBy(xpath = "//a[@id='btnSaveSignatureFormat']")
	WebElement CreateSignaturePopupUpSaveBtn;
	
	@FindBy(xpath = "//button[@id='btnCloseSignatureFormat']")
	WebElement CreateSignaturePopupCloseBtn;
	
	@FindBy(xpath = "//div[@class='toast toast-error']")
	WebElement CreateSignaturePopupValidationMsg;
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@FindBy(id = "fullNameCanvas")
	WebElement drawCanvas;
	
	@FindBy(xpath = "//a[@id='btnSaveSignatureFormat']")
	WebElement drawSignatureSaveBtn;
	
	
	@FindBy(xpath = "//label[@class='signature py-0 px-1']//img")
	List<WebElement> VerifySaveSignaturesList;
	
	// MySignatures Page Images

	public String validateMySignaturesPageTitle() throws InterruptedException {

		return driver.getTitle();
	}
	
	public String validateSignaturePageHeading() {
		
		return MySignatureHeading.getText();
	}
	
	public String validateCreateSignatureBtnText() {
		
		return CreateSignatureBtn.getText();
	}
	
	public String validateNoSignatureText1() {
		
		return NoSignatureText1.getText();
	}
	
	public String validateNoSignatureText2() {
		
		return NoSignatureText2.getText();
	}
	
	public void validateCreateSignatureBtnClick() {
		
		 CreateSignatureBtn.click();
	}
	
	
	
	// Create your signature Pop up Methods
	
	
	public boolean validateCreateSignaturePopupdisDisplayed() {
		
		wait.until(ExpectedConditions.visibilityOf(CreateSignaturePopup));
		return CreateSignaturePopup.isDisplayed();
		
	}
	
	public String validateCreateSignaturePopupHeading() {
		
		
		wait.until(ExpectedConditions.visibilityOf(CreateSignaturePopupHeading));
		return CreateSignaturePopupHeading.getText();
		
	}
	public String validateCreateSignaturePopupChooseBtnText() {
		
		return CreateSignaturePopupChooseBtn.getText();
		
	}
	public boolean validateCreateSignaturePopupChooseBtnActive() {
		
		return CreateSignaturePopupChooseBtn.getAttribute("class").contains("active-signature");
		
	}
	public void	validateCreateSignaturePopupChooseBtnClick() {
		
		CreateSignaturePopupChooseBtn.click();
	}
	
	public String validateCreateSignaturePopupDrawBtnText() {
		
		return CreateSignaturePopupDrawBtn.getText();
		
	}
	public boolean validateCreateSignaturePopupDrawBtnActive() {
		
		return CreateSignaturePopupDrawBtn.getAttribute("class").contains("active-signature");
		
	}
	public void	validateCreateSignaturePopupDrawBtnClick() {
		
		CreateSignaturePopupDrawBtn.click();
	}	
	public String validateCreateSignaturePopupUploadBtnText() {
		
		return CreateSignaturePopupUploadBtn.getText();
		
	}
	public boolean validateCreateSignaturePopupUploadBtnActive() {
		
		return CreateSignaturePopupUploadBtn.getAttribute("class").contains("active-signature");
		
	}
	public void	validateCreateSignaturePopupUploadBtnClick() {
		
		CreateSignaturePopupUploadBtn.click();
	}	

	
	public void validateCreateSignaturePopupUpCancleBtnClick() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void validateDrawSignatureAndSave() {
		
		CreateSignatureBtn.click();
		
		CreateSignaturePopupDrawBtn.click();
		
		
		Actions builder = new Actions(driver);

		// Draw a star (5-point)
		Action drawStar = builder
			    .moveToElement(drawCanvas, -80, 0)   // shift left inside canvas before starting
			    .clickAndHold()
			    .moveByOffset(0, -80)    
			    .moveByOffset(25, 80)   
			    .moveByOffset(-80, -50) 
			    .moveByOffset(80, 0)     
			    .moveByOffset(-80, 50) 
			    .moveByOffset(25, -80)
			    .moveByOffset(0, 80)
			    .moveByOffset(0, -80)
			    .moveByOffset(25, 80)
			    .moveByOffset(-80, -50)
			    .moveByOffset(80, 0)
			    .moveByOffset(-80, 50) 
			    .moveByOffset(25, -80)
			    .moveByOffset(0, 80)
			    .moveByOffset(0, -80)
			    .moveByOffset(25, 80)
			    .moveByOffset(-80, -50)
			    .moveByOffset(80, 0) 
			    .moveByOffset(-80, 50) 
			    .moveByOffset(25, -80)
			    
			    .release()
			    .build();

		// Perform the drawing
		drawStar.perform();
		
	    drawSignatureSaveBtn.click();
	    
		
		
	}
	
	
	public void validateChooseSignatureAndSave() {
		
		
	
	}
	
	
	
	
	
	

}
