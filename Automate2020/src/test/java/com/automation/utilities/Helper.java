package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;

public class Helper 
{
	public static String CaptureScreenshot(WebDriver driver)
	{
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = System.getProperty("user.dir")+"./Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		try 
		{
			//FileHandler.copy(ss, new File(screenshotPath));
			
			FileUtils.copyFile(ss,new File(screenshotPath));
			
		} catch (IOException e) 
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
	   }
		return screenshotPath;
	}
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date(); // import from java.util
		
		return customFormat.format(currentDate);
		
	}
	
	
}


