package com.qa.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfileScreen extends AcctScreen {

	public ProfileScreen(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]") private WebElement fullNameFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")private WebElement emailFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")private WebElement uneditablePhoneNoFld;
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")private WebElement phoneNoFld;
	@AndroidFindBy (accessibility = ("Location type" +"\n"+ "Home"))private WebElement locationTypeFld;
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")private WebElement addressFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")private WebElement uneditablePhoneFld;
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[3]")private WebElement cityFld;
	@AndroidFindBy (accessibility =("State"+"\n"+ "Lagos"))private WebElement stateFld;
	@AndroidFindBy (accessibility =("LGA"+"\n"+ "Select lga"))private WebElement LGAFld;
	@AndroidFindBy (accessibility ="Save changes")private WebElement saveChangesBtn;
	@AndroidFindBy (accessibility ="Edit")private WebElement editFld;
	@AndroidFindBy (accessibility ="Home")private WebElement home;
	@AndroidFindBy (accessibility ="Office")private WebElement office;
	@AndroidFindBy (accessibility ="Others")private WebElement others;
	@AndroidFindBy (accessibility ="Lagos")private WebElement lagos;
	@AndroidFindBy (accessibility ="Federal Capital Territory")private WebElement FCT;
	@AndroidFindBy (accessibility ="Oyo")private WebElement oyo;
	@AndroidFindBy (accessibility ="Ogun")private WebElement ogun;
	@AndroidFindBy (accessibility ="Kwara")private WebElement kwara;
	@AndroidFindBy (accessibility ="Ikeja")private WebElement ikeja;
	@AndroidFindBy (accessibility ="Alimosho")private WebElement alimosho;
	@AndroidFindBy (accessibility = "updating")private WebElement updatingIcon;
	
	
	public String fullNameProps () {
		return getAttribute(fullNameFld, "clickable");
	}
	
	public String emailProps () {
		return getAttribute(emailFld, "clickable");
	}
	public String phoneNoProps () {
		return getAttribute(uneditablePhoneNoFld, "clickable");
	}
	
	public ProfileScreen clickEdit () {
		click(editFld);
		return this;
	}
	
	public ProfileScreen scrollProfile () {
		scrollUsingElement(cityFld, 260,870);
		return this;
	}
	
	public ProfileScreen enterPhoneNo (String phoneNo) {
		click(phoneNoFld);
		clear(phoneNoFld);
		sendKeys(phoneNoFld, phoneNo);
		return this;
	}
	public ProfileScreen clickLocationType () {
		click(locationTypeFld);
		return this;
	}

	public ProfileScreen homeLocationType () {
		click(home);
		return this;
	}
	
	public ProfileScreen officeLocationType () {
		click(office);
		return this;
	}
	
	public ProfileScreen othersLocationType () {
		click(others);
		return this;
	}
	

	public ProfileScreen enterAddress (String address) {
		click(addressFld);
		clear(addressFld);
		sendKeys(addressFld, address);
		return this;
	}
	
	public ProfileScreen entercity (String city) {
		click(cityFld);
		clear(cityFld);
		sendKeys(cityFld, city);
		return this;
	}
	
	public ProfileScreen clickState () {
		click(stateFld);
		return this;
	}

	public ProfileScreen lagosState () {
		click(lagos);
		return this;
	}
	
	public ProfileScreen FCTState () {
		click(FCT);
		return this;
	}
	
	public ProfileScreen oyoState () {
		click(oyo);
		return this;
	}
	
	public ProfileScreen ogunState () {
		click(ogun);
		return this;
	}
	public ProfileScreen kwaraState () {
		click(kwara);
		return this;
	}
	
	public ProfileScreen clickLGA () {
		click(LGAFld);
		return this;
	}
	
	public ProfileScreen ikejaLGA () {
		click (ikeja);
		return this;
	}
	public ProfileScreen alimoshoLGA () {
		click (alimosho);
		return this;
	}
	
	public ProfileScreen clickSaveChanges () {
		click(saveChangesBtn);
		return this;
	}
	
	public String getAddress () throws Exception {
		click(uneditablePhoneFld);
		return getAttribute(uneditablePhoneFld, "text");
	}
	
	
	public ProfileScreen hideKeyboard() {
		 ProfileScreen.driver.navigate().back();
		 return this;
	 }
	
	public WebElement updating () {
		return updatingIcon;
	}
	
	public ProfileScreen saveChangesVisibility () {
		waitForInvisibility(saveChangesBtn);
		return this;
	}
}
