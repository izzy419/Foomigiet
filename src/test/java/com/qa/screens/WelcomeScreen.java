package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen extends NewTest {

	public WelcomeScreen (AppiumDriver driver) {
		  PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); }
	
	@AndroidFindBy (accessibility = "Create Account") private WebElement createAccountBtn;
	@AndroidFindBy (accessibility = "Log In") private WebElement log_inBtn;
	@AndroidFindBy (accessibility = "Get Started") private WebElement getStartedBtn;
	
	public CreateAccountScreen createAcct () {
		click(createAccountBtn);
		return new CreateAccountScreen(driver);
	}
	
	public LoginScreen loginDr () {
		click(log_inBtn);
		return new LoginScreen(driver);
	}
	
	public GuestSessionHomeScreen getStarted() {
		click(getStartedBtn);
		return new GuestSessionHomeScreen(driver);
	}
}
