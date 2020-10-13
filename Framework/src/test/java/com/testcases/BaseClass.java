package com.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass
{
	WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentSparkReporter extent;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	@BeforeSuite()
	public void setUpSuite() throws FileNotFoundException
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		
		
		excel = new ExcelDataProvider();
		//excel.getStringData("Login", 0, 0);
		config = new ConfigDataProvider();
		
		extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/FreeCRM" + Helper.getCurrentDateTime() +".html"));
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be started", true);
		
	}
	
	@BeforeClass
	public void setUp()
	{
		
		Reporter.log("Trying to start Browser and Getting application ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and Application is up and running" , true);
		
	}

	
	@AfterClass
	public void tearDown()
	{
		//BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)throws IOException
	{
		Reporter.log("Test is about to end" , true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		report.flush();
		
		Reporter.log("Test Completed>>Reports Generated", true);
	}
	
	
}

