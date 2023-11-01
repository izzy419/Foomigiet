package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen extends NewTest{
	
	public BaseScreen (AppiumDriver driver) {
		  PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); }


 	@AndroidFindBy (accessibility = "Log In")private WebElement BSloginBtn;
	@AndroidFindBy (accessibility = "Create Account")private WebElement BSCreateAcctBtn;
	@AndroidFindBy (accessibility = "Get Started")private WebElement getStartedBtn;
	
	public LoginScreen clickBSloginBtn () {
		click(BSloginBtn);
		return new LoginScreen(driver);
	}
	
	public CreateAccountScreen clickBSCreateAcctBtn0 () {
		click(BSCreateAcctBtn);
		return new CreateAccountScreen(driver);
	}
	
	public CreateAccountScreen clickGetStartedBtn () {
		click(getStartedBtn);
		return new CreateAccountScreen(driver);
	}
	
}
