package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen extends NewTest{


 	@AndroidFindBy (accessibility = "Log In")private WebElement BSloginBtn;
	@AndroidFindBy (accessibility = "Create Account")private WebElement BSCreateAcctBtn;
	@AndroidFindBy (accessibility = "Get Started")private WebElement getStartedBtn;
	
	public LoginScreen clickBSloginBtn () {
		click(BSloginBtn);
		return new LoginScreen();
	}
	
	public CreateAccountScreen clickBSCreateAcctBtn0 () {
		click(BSCreateAcctBtn);
		return new CreateAccountScreen();
	}
	
	public CreateAccountScreen clickGetStartedBtn () {
		click(getStartedBtn);
		return new CreateAccountScreen();
	}
	
}
