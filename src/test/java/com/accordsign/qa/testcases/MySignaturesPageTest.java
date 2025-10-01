package com.accordsign.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accordsign.qa.base.TestBase;
import com.accordsign.qa.pages.HomePage;
import com.accordsign.qa.pages.LoginPage;
import com.accordsign.qa.pages.MySignaturesPage;

public class MySignaturesPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	MySignaturesPage mySignaturesPage;

	public MySignaturesPageTest() {

		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateValidLogin(prop.getProperty("username"), prop.getProperty("password"));
		mySignaturesPage = homepage.validateMySettingMySignaturesLink();
	}
	
	
	@Test(priority=1)// Validation message testcases remaining.
	public void ValidateMySignaturesPageTitleTest() throws InterruptedException {
		
		String ProfilePageTitle = mySignaturesPage.validateMySignaturesPageTitle();
		Assert.assertEquals(ProfilePageTitle,"Accordsign | Signature Format Page", "Signature Page Title is not matched");
		
	}
	

	
	@Test(priority=2)
	public void validateSignaturePageElementTest() {
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(mySignaturesPage.validateSignaturePageHeading(),"Signatures (0 of 3 Signatures)");
		softAssert.assertEquals(mySignaturesPage.validateCreateSignatureBtnText(),"+ Create Signature");
		softAssert.assertEquals(mySignaturesPage.validateNoSignatureText1(),"No Saved Signatures Found.");
		softAssert.assertEquals(mySignaturesPage.validateNoSignatureText2(),"Please create or upload a new signature to proceed.");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void validateCreateSignaturePopupElementTest() {
		
		SoftAssert softAssert = new SoftAssert();
		
		mySignaturesPage.validateCreateSignatureBtnClick();
		softAssert.assertTrue(mySignaturesPage.validateCreateSignaturePopupdisDisplayed(),"Create Signature PopUp is not Displayed");
		softAssert.assertEquals(mySignaturesPage.validateCreateSignaturePopupHeading(),"Create your signature");
		softAssert.assertEquals(mySignaturesPage.validateCreateSignaturePopupChooseBtnText(),"Choose");
		softAssert.assertTrue(mySignaturesPage.validateCreateSignaturePopupChooseBtnActive(),"Create Signature Choose Button is not Displayed Selected");
		mySignaturesPage.validateCreateSignaturePopupDrawBtnClick();
		softAssert.assertEquals(mySignaturesPage.validateCreateSignaturePopupDrawBtnText(),"Draw");
		softAssert.assertTrue(mySignaturesPage.validateCreateSignaturePopupDrawBtnActive(),"Create Signature Draw Button is not Displayed Selected");
		mySignaturesPage.validateCreateSignaturePopupUploadBtnClick();
		softAssert.assertEquals(mySignaturesPage.validateCreateSignaturePopupUploadBtnText(),"Upload");
		softAssert.assertTrue(mySignaturesPage.validateCreateSignaturePopupUploadBtnActive(),"Create Signature Upload Button is not Displayed Selected");
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority=2)
	public void validateDrawSignatureAndSave() {
		
		mySignaturesPage.validateDrawSignatureAndSave();
		
		
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	

}
