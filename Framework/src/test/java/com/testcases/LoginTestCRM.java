package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

//import com.pages.LoginPage;
//import com.utility.BrowserFactory;
//import com.utility.ExcelDataProvider;
//import com.utility.Helper;

public class LoginTestCRM extends BaseClass
{
	
	@Test(priority=1)
	public void loginApp()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		//excel.getStringData("Login", 0, 0);
		
		logger = report.createTest("Login to CRM");
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login");
		
		
		//System.out.println(driver.getTitle());
		
		Helper.captureScreenshot(driver);
		
	}
	
	@Test(priority=2)
	public void loginApp2()
	{
		//ExcelDataProvider excel = new ExcelDataProvider();
		//excel.getStringData("Login", 0, 0);
		
		logger = report.createTest("Logout");
		
		
		logger.fail("Logout failed");
		
		
		
		
		
		
		//System.out.println(driver.getTitle());
		
		//Helper.captureScreenshot(driver);
		
	}
	
	

}
