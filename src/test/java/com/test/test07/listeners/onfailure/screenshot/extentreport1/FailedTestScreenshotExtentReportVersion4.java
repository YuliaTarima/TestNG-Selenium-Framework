package com.test.test07.listeners.onfailure.screenshot.extentreport1;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.Base;

public class FailedTestScreenshotExtentReportVersion4 extends Base {

	/*
	 * see the report file in /test-output/ExtentReport.html
	 */

	public ExtentHtmlReporter htmlReporter; // responsible for look and feel of the report
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeMethod
	public void setUp() {
		initialize("https://www.google.com/", "chrome");
	}

	@BeforeTest
	public void setExtentReport() {
		//set report folder
		String reportUrl = System.getProperty("user.dir") + "/test-output/ExtentReportVersion4.html";
		htmlReporter = new ExtentHtmlReporter(reportUrl);

		htmlReporter.config().setEncoding("utf-8");
		// set report title
		htmlReporter.config().setDocumentTitle("Automation Report");
		// set report name
		htmlReporter.config().setReportName("Functional Report");
		// sets dark theme
		htmlReporter.config().setTheme(Theme.DARK);
		String css = ".r-img {width: 100%;} .screenshots > li img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);// attach reporter to extent object

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
		//Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		//Assert.assertTrue(logo);
		throw new SkipException("Let's skip this test on purpose");
	}

	@Test
	public void googleLoginTest() {
		extentTest = extent.createTest("googleLoginTest");
		// create sub-case for valid input
		extentTest.createNode("Login with valid input");
		Assert.assertEquals(true, true, "Let's pass this test on purpose");
		// create sub-case for invalid input
		extentTest.createNode("Login with invalid input");
		Assert.assertEquals(true, true, "Let's pass this test on purpose");
		//Assert.fail("Let's fail this test on purpose");
	}

	@AfterTest
	public void endExtentReport() {
		extent.flush();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			String logText = "TEST CASE FAILED: " + result.getName();// add test name
			Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.log(Status.FAIL, markUp);
			
			// adds error/exception in extent report
			extentTest.log(Status.FAIL, "EXCEPTION OCCURED: "+ result.getThrowable());
			
			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Click to see StackTrace"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");

			String screenshotPath = Util.getScreenshot(driver, result.getName());
			// adds screenshot in extent report
			extentTest.addScreenCaptureFromPath(screenshotPath);
			// adds screencast/video in extent report
			// extentTest.addScreencastFromPath(screenshotPath);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String logText = "<b>" + "TEST CASE SKIPPED: " + result.getName() + "</b>";
			Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			extentTest.log(Status.SKIP, markUp);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
	
			String logText = "<b>" + "TEST CASE PASSED: " + result.getName() + "</b>";
			Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.log(Status.PASS, markUp);

		}
		killBrowser();
	}

}
