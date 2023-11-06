package com.qa.test;

import org.testng.annotations.Test;

import com.qa.NewTest;
import com.qa.screens.AcctScreen;
import com.qa.screens.BaseScreen;
import com.qa.screens.HomeScreen;
import com.qa.screens.LoginScreen;
import com.qa.screens.NavBar;
import com.qa.screens.ProfileScreen;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ProfileUpdate extends NewTest {
 
	BaseScreen baseScreen;
	LoginScreen login;
	NavBar navbar;
	AcctScreen acct;
	ProfileScreen profile;
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
	  System.out.println("\n" + " ****** starting test: " + m.getName()+ "***** " + "\n");
	  login = baseScreen.clickBSloginBtn();
	  
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  
  @Test()
  public void successfulLogin() throws Exception {
	  
	  navbar = login.login((loginUsers.getJSONObject("validEmailAndPassword").getString("email")),
    		  (loginUsers.getJSONObject("validEmailAndPassword").getString("password")));
      
      acct = navbar.clickAccount();
      profile = acct.profile();
      
      Assert.assertEquals(profile.fullNameProps(), "false");
      Assert.assertEquals(profile.emailProps(), "false");
      
	 
	
	  
  }
  
  
}
