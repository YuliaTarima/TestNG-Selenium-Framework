package com.test.test6.screenshotfailed;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;

public class FailedTestScreenshotExtentReportV4 extends ScreenshotTestBase {
	
	/*
	 * see the report file in /test-output/ExtentReport.html
	 */
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	public ExtentHtmlReporter html;
	
	 
	

	 ExtentReporter extentx = new ExtentLoggerReporter("localhost");
	 extent.attachReporter(html, extentx);
	 
	 extent.createTest("TestName").pass("Test Passed");
	 
	 extent.flush();

	

	@BeforeMethod
	public void setUp(){
	initialization();
	}
	
	@BeforeTest
	public void setExtentReport(){
		String reportUrl = System.getProperty("user.dir")+"/test-output/ExtentReport.html";
		//extent = new ExtentReports(reportUrl, true);
		extent = new ExtentReports();
		html = new ExtentHtmlReporter("Extent.html");
		extent.addSystemInfo("Host Name", "localhost");
		extent.addSystemInfo("User Name", "InCoding Girls");
		extent.addSystemInfo("Environment", "QA");
	}
	
	@Test
	public void googleTitleTest(){
		extentTest = extent.startTest("googleTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Let's fail this test on purpose");
	}
	
	@Test
	public void googleLogoTest(){
		extentTest = extent.startTest("googleLogoTest");
		Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@AfterTest
	public void endExtentReport(){
			extent.flush();
			extent.close();
	}	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			//adds test name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED: "+result.getName()); 
			//adds error/exception in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED: "+result.getThrowable()); 
			
			String screenshotPath = FailedTestScreenshotExtentReportV4.getScreenshot(driver, result.getName());
			//adds screenshot in extent report
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
			//adds screencast/video in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); 
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());

		}
		
		//ends the current test and prepares to create html report
		extent.endTest(extentTest); 
		finishUp();  
	}

}
