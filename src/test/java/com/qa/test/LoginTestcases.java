package com.qa.test;

import org.testng.annotations.Test;

import com.qa.NewTest;
import com.qa.screens.BaseScreen;
import com.qa.screens.HomeScreen;
import com.qa.screens.LoginScreen;
import com.qa.screens.WelcomeScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginTestcases extends NewTest {
 
	BaseScreen baseScreen;
	LoginScreen login;
	WelcomeScreen welcomeScreen;
	HomeScreen homeScreen;
	InputStream loginData;
	JSONObject loginUsers;
  
  @BeforeClass
  public void beforeClass() throws Exception {
		try {
			String dataFileName = "FoomigietTestData/loginData.json";
			loginData = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(loginData);
			loginUsers = new JSONObject(tokener);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			if(loginData != null) {
				loginData.close();
			}
		}
	  }
  
  @AfterClass
     public void afterClass() {
     }

  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	  baseScreen = new BaseScreen(driver);
	  login =	baseScreen.clickBSloginBtn(); 
	  System.out.println("\n" + " ****** starting test: " + m.getName()+ "***** " + "\n");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @Test
  public void invalidEmailOrPhone() {
	  
	   login.enterEmail("olasehindedammi@gmail.com");
	  //loginUsers.getJSONObject("invalidEmail").getString("email")
	  login.enterPassword("Password1@");
	  //loginUsers.getJSONObject("invalidEmail").getString("password")
	  login.login();
	  
	  boolean actualErrorMsg = login.getErrMsg();
//	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
//	  
//	  System.out.println("Actaul error message: " + actualErrorMsg + "\n" + " Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, true);
	  
	  login.enterEmailClear();
	  login.enterPasswordClear();
	  
	  
  }
  
  @Test
  public void invalidPassword() {
	  login.enterEmail(loginUsers.getJSONObject("inavlidPassword").getString("email"));
	  login.enterPassword(loginUsers.getJSONObject("inavlidPassword").getString("password"));
	  login.login();
	  
	  boolean actualErrorMsg =login.getErrMsg();
//	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
//	  
//	  System.out.println("Actaul error message: " + actualErrorMsg + "\n " + " Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, true);
	  
	  login.enterEmailClear();
	  login.enterPasswordClear();
	
	  	  
  }
  
  @Test
  public void successfulLogin() throws Exception {
	  login.enterEmail(loginUsers.getJSONObject("validEmailAndPassword").getString("email"));
	  login.enterPassword(loginUsers.getJSONObject("validEmailAndPassword").getString("password"));
	  homeScreen = login.login();
	  
	  String homeMessage = homeScreen.getHomeMsg();
	  
	  String expectedHomeMsg = "Book a fumigation service today";
	  
	  System.out.println("Actaul home message: " + homeMessage + "\n " + " Expected home message: " + expectedHomeMsg);
	  
	  Assert.assertEquals(homeMessage, expectedHomeMsg);
	  
	  
  }
  
  
}
