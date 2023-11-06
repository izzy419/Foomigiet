package com.qa.screens;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AcctScreen extends NavBar {

	public AcctScreen(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy (accessibility ="Profile")private WebElement profileBtn;
	@AndroidFindBy (accessibility ="Change Password")private WebElement changePasswordBtn;
	@AndroidFindBy (accessibility ="Privacy Policy")private WebElement privacyPolicyBtn;
	@AndroidFindBy (accessibility ="Delete my account")private WebElement deleteMyAcctBtn;
	@AndroidFindBy (accessibility ="Logout")private WebElement logoutBtn;
	
	public ProfileScreen profile () {
		click(profileBtn);
		return new ProfileScreen(driver);
	}
	
	public ChangePasswordScreen changePassword () {
		click(changePasswordBtn);
		return new ChangePasswordScreen(driver);
	}
	
	public PrivacyPolicyPage privacyPolicy() {
		click(privacyPolicyBtn);
		return new PrivacyPolicyPage();
	}
	
	public DeleteAcctPage deleteAcct() {
		click(deleteMyAcctBtn);
		return new DeleteAcctPage();
	}
	
	public LoginScreen logout() {
		 click(logoutBtn);
		 return new LoginScreen(driver);
	}
	
		
}
