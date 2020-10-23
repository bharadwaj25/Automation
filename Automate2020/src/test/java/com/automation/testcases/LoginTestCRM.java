package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.Helper;

public class LoginTestCRM extends BaseClass
{
	@Test
    public void loginApp() throws InterruptedException
    {
		Reporter.log("Trying to login to application", true);
		
		logger = report.createTest("Login To CRM");
		
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        
        logger.info("Starting Application");

		loginPage.loginToCrm(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));

        Thread.sleep(5000);
        
        Helper.CaptureScreenshot(driver);
        
        logger.pass("Login Successful");
        
        Reporter.log("Login to application successful", true);
        
    }

}
