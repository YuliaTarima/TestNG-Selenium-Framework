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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FailedTestScreenshotExtentReportVersion4 extends ScreenshotTestBase {

	/*
	 * see the report file in /test-output/ExtentReport.html
	 */

	public ExtentHtmlReporter htmlReporter; //responsible for look and feel of the report
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@BeforeTest
	public void setExtentReport() {
		String reportUrl = System.getProperty("user.dir") + "/test-output/ExtentReportVersion4.html";

		htmlReporter = new ExtentHtmlReporter(reportUrl);
		//set report title
		htmlReporter.config().setDocumentTitle("Automation Report");
		//set report name
		htmlReporter.config().setReportName("Functional Report");
		//sets dark theme
		htmlReporter.config().setTheme(Theme.DARK);
		String css = ".r-img {width: 100%;} .screenshots > li img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);//attach reporter to extent object
		
		//add any details to report in key-value format
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("User Name", "InCoding Girls");
		extent.setSystemInfo("Environment", "QA");
	}

	@Test
	public void googleTitleTest() {
		extentTest = extent.createTest("googleTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Let's fail this test on purpose");
	}

	@Test
	public void googleLogoTest() {
		extentTest = extent.createTest("googleLogoTest");
		Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void googleLoginTest() {
		extentTest = extent.createTest("googleLoginTest");
		//create sub-case for valid input
		extentTest.createNode("Login with valid input");
		Assert.assertTrue(true);
		//create sub-case for invalid input
		extentTest.createNode("Login with invalid input");
		Assert.assertTrue(false);
	}	

	@AfterTest
	public void endExtentReport() {
		extent.flush();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// adds test name in extent report
			extentTest.log(Status.FAIL, "TEST CASE FAILED: " + result.getName());
			// adds error/exception in extent report
			extentTest.log(Status.FAIL, "TEST CASE FAILED: " + result.getThrowable());

			String screenshotPath = FailedTestScreenshotExtentReportVersion4.getScreenshot(driver, result.getName());
			// adds screenshot in extent report
			extentTest.addScreenCaptureFromPath(screenshotPath);
			// adds screencast/video in extent report
			//extentTest.addScreencastFromPath(screenshotPath);
		
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "TEST CASE SKIPPED: " + result.getName());
		
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "TEST CASE PASSED: " + result.getName());

		}

		finishUp();
	}

}
