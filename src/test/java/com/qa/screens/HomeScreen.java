package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends NewTest{

	public HomeScreen (AppiumDriver driver) {
		 PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); 
	}

	@AndroidFindBy (accessibility ="Book a fumigation service today") WebElement homeMsg;
	
	public String getHomeMsg() {
		 return getAttribute1(homeMsg, "content-desc");
	 }

}
