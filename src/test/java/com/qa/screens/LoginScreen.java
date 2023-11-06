package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends BaseScreen{
              
	public LoginScreen(AppiumDriver driver) {
		super(driver);
	}


	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]") private WebElement emailTxtFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")private WebElement passwordTxtFld;
	@AndroidFindBy (accessibility = "Login")private WebElement loginBtn;
	@AndroidFindBy (accessibility = "Forgot Password?") private WebElement errorMsg;
	@AndroidFindBy (accessibility = "input a valid email") private WebElement invalidMailErrMsg;
	@AndroidFindBy (accessibility = "required") private WebElement required;
	
	public boolean invalidMailErrMsgDis () {
		return invalidMailErrMsg.isDisplayed();
	}
	
	public boolean requiredDis () {
		return required.isDisplayed();
	}
	public LoginScreen enterEmail (String email) {
		click(emailTxtFld);
		sendKeys(emailTxtFld, email); 
		return this;
	 }
	 
	 public LoginScreen enterEmailClear () {
		 click(emailTxtFld);
		 clear(emailTxtFld);
		 return this;
	 }
	 
	 
	 public LoginScreen enterPassword (String password) {
		 click(passwordTxtFld);
		 sendKeys(passwordTxtFld, password);
		 return this;
	 }
	 
	 public LoginScreen enterPasswordClear () {
		 click(passwordTxtFld);
		 clear(passwordTxtFld);
		 return this;
	 }
	 
	 public LoginScreen hideKeyboard() {
		 LoginScreen.driver.navigate().back();
		 return this;
	 }
	 
	 
	 public WebElement getErrMsg() {
		 return errorMsg ;
	 }

	 
	 public HomeScreen clickLogin () {
		 click(loginBtn);
		 return new HomeScreen(driver);
	 }
	 
	 public NavBar login (String username, String password) {
		enterEmail(username);
		enterPassword(password);
		clickLogin();
		return new NavBar(driver); 
	 }
	
}
