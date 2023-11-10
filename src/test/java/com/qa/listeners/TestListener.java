package com.qa.listeners;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.NewTest;

public class TestListener implements ITestListener{
	
	public void onTestFaliure (ITestResult result) {
		if (result.getThrowable() != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());
		}
	    NewTest newtest = new NewTest();
	    File file = newtest.getDriver().getScreenshotAs(OutputType.FILE);
	    
	    Map <String,String> params = new HashMap <String, String>();
	    params = result.getTestClass().getXmlTest().getAllParameters();
	    
	    String imagePath = "Screenshots" + File.separator + params.get("platformName")+ "_"+ params. get("platformVersion")+ "_"
	    				+ params.get ("deviceName") + File.separator + newtest.getDateTime() + File. separator
	    				+ result.getTestClass().getRealClass().getSimpleName() + File. separator + result.getName()+".png";
	    
	    try {
			FileUtils.copyFile(file, new File (imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
