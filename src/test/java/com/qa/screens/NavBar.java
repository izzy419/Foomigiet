package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.NewTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NavBar extends NewTest {


	@AndroidFindBy (accessibility =" Home")private WebElement home;
	@AndroidFindBy (accessibility =" Account")private WebElement account;
	@AndroidFindBy (accessibility =" Schedule")private WebElement schedule;
	
	public HomeScreen clickHome() {
		click(home);
		return new HomeScreen();
	}
	
	public AcctScreen clickAccount() {
		click (account);
		return new AcctScreen();
	}
	
	public ScheduleScreen clickShedule () {
		click (schedule);
		return new ScheduleScreen();
	}
}
