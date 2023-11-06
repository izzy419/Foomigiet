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
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")private WebElement phoneNoFld;
	@AndroidFindBy (accessibility ="Location type\r\n"+ "Home")private WebElement locationTypeFld;
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")private WebElement addressFld; 
	@AndroidFindBy (xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[3]")private WebElement cityFld;
	@AndroidFindBy (accessibility ="State\r\n"+ "Lagos")private WebElement stateFld;
	@AndroidFindBy (xpath ="LGA\r\n"+ "Select lga")private WebElement LGAFld;
	@AndroidFindBy (accessibility ="Save changes")private WebElement saveChangesBtn;
	@AndroidFindBy (accessibility ="Edit")private WebElement editFld;
	
	public String fullNameProps () {
		click(fullNameFld);
		return getAttribute(fullNameFld, "clickable");
	}
	
	public String emailProps () {
		click(fullNameFld);
		return getAttribute(emailFld, "clickable");
	}
}
