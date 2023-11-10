package com.qa;

import com.google.common.collect.ImmutableMap;
import com.qa.utilis.Testutilis;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	protected static AppiumDriver driver;
	protected  static Properties props;
	protected static String dateTime;
	Testutilis utils;
	InputStream inputStream;	
	 

  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  utils = new Testutilis();
	  dateTime = utils.getDateTime();
	  try {

		  props = new Properties();
		  String propsFileName = "config.properties";
		  inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
		  props.load(inputStream);
		  
		  UiAutomator2Options options = new UiAutomator2Options().
				  setDeviceName(props.getProperty("deviceName")).
				  setPlatformName("Android").
				  setPlatformVersion("12").
				  setAutoGrantPermissions(true).
				  setUdid(props.getProperty("Udid")).
				  setAutomationName(props.getProperty("androidAutomationName")).
				  setAppPackage(props.getProperty("androidAppPackage")).
				  setAppActivity(props.getProperty("androidAppActivity"));
			      
				  	
			
			
			 // String appURL = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
			  
			  //caps.setCapability("app",appURL);
			
			
			
			
//			caps.setCapability("newCommandTimeout", 300);
			
			URL url = new URL(props.getProperty("appiumUrl"));
			
			 driver = new AndroidDriver(url, options);
			 String sessionId = driver.getSessionId().toString();
				System.out.println(sessionId);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				By skipBtn = AppiumBy.accessibilityId("Skip");
				
				driver.findElement(skipBtn).click();

				
		  
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
	  
	  }
  
   public AppiumDriver getDriver () {
	   return driver;
   }
  
   public String getDateTime() {
	   return dateTime;
   }
        public void waitForVisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));// You removed the Testutilis.WAIT variable here because it kept returning the input is null error
        	wait.until(ExpectedConditions.visibilityOf(e));
        	 }
        public void waitForInvisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));// You removed the Testutilis.WAIT variable here because it kept returning the input is null error
        	wait.until(ExpectedConditions.invisibilityOf(e));
        	 }
        
        public void click (WebElement e) {
        	waitForVisibility(e);
        	e.click();
        }
        
      
        public void clear (WebElement e) {
        	waitForVisibility(e);
        	e.clear();
        }

        public void clear (AppiumDriver driver ) {
        	driver.navigate().back();
        }
        public void sendKeys (WebElement e, String txt) {
        	waitForVisibility(e);
        	e.sendKeys(txt);
        }
        
        
        
        public String getAttribute (WebElement e, String attribute) {
        	waitForVisibility(e);
        	return e.getAttribute(attribute);
        }
        
       public void swipeAction (WebElement e,String direction) {
    	   waitForVisibility(e);
    	   ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
    	       "elementId", ((RemoteWebElement) e).getId(), 
    	       "direction", direction,
    	       "percent", 0.75
    	   ));
       }
       
       public void longPressAction (WebElement e) {
        	   waitForVisibility(e);
        	   ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
        	       "elementId", ((RemoteWebElement) e).getId(),
        	       "duration", 2000
        	   ));
       }
       
       public void scrollUsingElement (WebElement e,int x,int y) {
    	   waitForVisibility(e);
    	   ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    	       "elementId", ((RemoteWebElement) e).getId(),
    	       "endX", x,
    	       "endY", x
    	   ));
       }
       
//       public WebElement scrollToElement () {
//    	   return driver.findElement(AppiumBy.androidUIAutomator(
//    			   
////    			   "new UiScrollable(new UiSelector()" + ".description(\"<parent_locator>")).scrollIntoView("
////			   		+ "new UiSelector().description(\"<child_locator>\"));");
//    			   
//    		        "new UiScrollable(new UiSelector().scrollable(true))." +
//                    "scrollIntoView(" +
//                        "new UiSelector().description(\"test-Price\")" +
//                    ");"
//                        )
//    			  }
       
       public void closeApp() {
    	((InteractsWithApps)driver).terminateApp(props.getProperty("androidAppPackage"));
       }

       public void launchApp () {
    	   ((InteractsWithApps)driver).activateApp(props.getProperty("androidAppPackage"));
       }
 @AfterTest
  public void afterTest() {
	 driver.quit();
  }
 

}


