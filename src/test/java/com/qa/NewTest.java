package com.qa;

import com.qa.utilis.Testutilis;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	protected static AppiumDriver driver;
	protected  static Properties props;
	InputStream inputStream;	
	 

  @BeforeTest
  public void beforeTest() throws Exception {
	  
	   
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
			  //By LogInBtn = AppiumBy.accessibilityId("Log In");
//			    By email = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
//			    By password = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
//				By log = AppiumBy.accessibilityId("Login");
//			    ////android.widget.Button[@content-desc="Skip"]
				
				driver.findElement(skipBtn).click();
				//driver.findElement(LogInBtn).click();
//				driver.findElement(email).click();
//				driver.findElement(email).sendKeys("oladehindedammi@gmail.com");
//				driver.findElement(password).click();
//				driver.findElement(password).sendKeys("Password1@");
//				driver.findElement(log).click();
				
		  
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
	  
	  }
  
        public void waitForVisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));// You removed the Testutilis.WAIT variable here because it kept returning the input is null error
        	wait.until(ExpectedConditions.visibilityOf(e));
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
       


 @AfterTest
  public void afterTest() {
	 driver.quit();
  }
 

}


