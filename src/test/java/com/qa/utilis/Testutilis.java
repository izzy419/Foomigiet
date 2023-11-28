package com.qa.utilis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Testutilis {

	public static final long WAIT = 60;
	
	public String dateTime () {
		DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);	
		
		
	}
	
	public Logger log () {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
}
