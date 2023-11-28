package com.qa;

import com.google.common.collect.ImmutableMap;

import com.qa.utilis.Testutilis;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.netty.handler.codec.base64.Base64;

public class NewTest {
	
	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal <AppiumDriver> ();
	protected  static ThreadLocal <Properties> props = new ThreadLocal <Properties>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal <String>();
	Testutilis utils;
	
	
	public NewTest () {
		  PageFactory.initElements(new AppiumFieldDecorator(getDriver()) ,this);
		  }
	
	   public AppiumDriver getDriver () {
		   return driver.get();
	   }
	   
	   public void setDriver (AppiumDriver driver2) {
		   driver.set(driver2);
	   }
	  
	   public Properties getProps () {
		   return props.get();
	   }
	   public void setProps (Properties prop2) {
		   props.set(prop2);
	   }
	  
	   public String getDateTime () {
		   return dateTime.get();
	   }
	   public void setDateTime (String dateTime2) {
		   dateTime.set(dateTime2);
	   }
	   
	 

	@BeforeMethod
	public void beforeMethod() {
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}
	
	@AfterMethod
	public synchronized void afterMethod (ITestResult result) {
		
		String media  = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		
		if (result.getStatus()== 2) {
			Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
			
			String dir = "videos" + File.separator + params.get("platformName")+ "_"+ params. get("platformVersion")+ "_"
					+ params.get ("deviceName") + File.separator + getDateTime() + File. separator
					+ result.getTestClass().getRealClass().getSimpleName();
			
			File videoDir = new File(dir);
			
			synchronized(videoDir) {
			if (!videoDir.exists()) {
				videoDir.mkdirs();
			}}
			
			try {
				FileOutputStream stream = new FileOutputStream(videoDir + File. separator + result.getName()+".mp4");
				stream.write(org.apache.commons.codec.binary.Base64.decodeBase64(media));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
		}
		
	}
	
  @Parameters ({"emulator", "platformName", "platformVersion", "udid", "deviceName","systemPort","chromeDriverPort"})
  @BeforeTest
  public void beforeTest(@Optional("androidOnly") String emulator, String platformName, String platformVersion, String udid, String deviceName, @Optional("androidOnly") String chromeDriverPort,@Optional("androidOnly") 
  String systemPort ) throws Exception {
	  
	  InputStream inputStream = null;
	  utils = new Testutilis();
	  setDateTime(utils.dateTime());
	  Properties props = new Properties();
	  AppiumDriver driver;

	  String strfile = "logs" +File.separator + platformName + "_" + deviceName;
	  File logFile = new File(strfile);
	  if (!logFile.exists()) {
		  logFile.mkdir();
	  }
	  ThreadContext.put("ROUTINGKEY", strfile);
	  
	  try {

		  props = new Properties();
		  String propsFileName = "config.properties";
		  inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
		  props.load(inputStream);
		  setProps(props);
		  
		  URL url = new URL(props.getProperty("appiumUrl"));
		  
		  switch(platformName) {
		  
		  case "Android" : UiAutomator2Options options = new UiAutomator2Options().
				  setDeviceName(deviceName).
				  setPlatformName("Android").
				  setPlatformVersion(platformVersion).
				  setAutoGrantPermissions(true).
				  setUdid(udid).
				  setAutomationName(props.getProperty("androidAutomationName")).
				  setAppPackage(props.getProperty("androidAppPackage")).
				  setAppActivity(props.getProperty("androidAppActivity")).
				  setAdbExecTimeout(Duration.ofSeconds(Testutilis.WAIT));
			      
			
			
			
			 driver = new AndroidDriver(url, options);
			 String sessionId = driver.getSessionId().toString();
			 utils.log().info(sessionId);
               
				By skipBtn = AppiumBy.accessibilityId("Skip");
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Testutilis.WAIT));
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(skipBtn)).click();

				
				setDriver(driver);
				
				break;
			
		  case "iOS" : XCUITestOptions options1 = new XCUITestOptions().
				  setDeviceName(deviceName).
				  setPlatformName("IOS").
				  setPlatformVersion(platformVersion).
				  setUdid(udid).
				  setBundleId("").
				  setAutomationName("XCUITest").
				  setApp(props.getProperty("appUrl"));
		
		
		 driver = new IOSDriver(url, options1);
		 String sessionId2 = driver.getSessionId().toString();
		 utils.log().info(sessionId2);
			
			By skipBtn1 = AppiumBy.accessibilityId("Skip");
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(Testutilis.WAIT));
			
			wait2.until(ExpectedConditions.visibilityOfElementLocated(skipBtn1)).click();

			
			setDriver(driver);
			
			break;
			
		default: 
			throw new Exception("Invalid platform! -" +platformName); 
		  }
		  			
						 
				
		  
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
	  
	  }
  

        public void waitForVisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Testutilis.WAIT));// You removed the Testutilis.WAIT variable here because it kept returning the input is null error
        	wait.until(ExpectedConditions.visibilityOf(e));
        	 }
        public void waitForInvisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));// You removed the Testutilis.WAIT variable here because it kept returning the input is null error
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
    	   ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", ImmutableMap.of(
    	       "elementId", ((RemoteWebElement) e).getId(), 
    	       "direction", direction,
    	       "percent", 0.75
    	   ));
       }
       
       public void longPressAction (WebElement e) {
        	   waitForVisibility(e);
        	   ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture", ImmutableMap.of(
        	       "elementId", ((RemoteWebElement) e).getId(),
        	       "duration", 2000
        	   ));
       }
       
       public void scrollUsingElement (WebElement e,int x,int y) {
    	   waitForVisibility(e);
    	   ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture", ImmutableMap.of(
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

    	((InteractsWithApps)getDriver()).terminateApp(getProps().getProperty("androidAppPackage"));
       }

       public void launchApp () {
    	   ((InteractsWithApps)getDriver()).activateApp(getProps().getProperty("androidAppPackage"));
       }
 @AfterTest
  public void afterTest() {
	 getDriver().quit();
  }
 

}


