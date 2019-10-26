package com.test.test07.listeners.onfailure.screenshot.extentreport2;

import java.io.IOException;
import java.util.Arrays;

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
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.Base;

public class TestCase1ManualExtentSetup extends Base{

	/*
	 * This is an example of manual setup
	 * of Extent Report 
	 * per each test case within a class
	 * 
	 * Alternative is a dynamic setup
	 * through Listeners
	 * src/test/java/com/test/test07/listeners/onfailure/screenshot/extentreport2/TestCase2DynamicExtentSetup.java
	 * 
	 * Run this test from this class
	 * 
	 * see the report file in /test-output/ExtentReport.html
	 * test-output/ExtentReportV4.html
	 */

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeMethod
	public void setUp() {
		setWebDriverManager("chrome");
	}
	

	@BeforeTest
	public void setReport() {
		// set the reports folder
		String reportUrl = System.getProperty("user.dir") + "/test-output/ExtentReportV4.html";
		htmlReporter = new ExtentHtmlReporter(reportUrl);

		// set look and feel
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("InCodingGirls Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		String css = ".r-img {width: 100%;} .step-details > img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// add any details to report in key-value format
		extent.setSystemInfo("SDET", "InCoding Girls");
		extent.setSystemInfo("Orgainzation", "InCodingGirls");
		extent.setSystemInfo("Build No", "W2A-1234");

	}

	@AfterTest
	public void endReport() {
		// flush output to html file
		extent.flush();
	}

	/*
	 * Pass, Fail, Skip
	 * 
	 */

	@Test
	public void doUserReg() {

		test = extent.createTest("User Reg Test");
		Assert.fail("User Reg Test Failed");
	}

	@Test
	public void doLogin() {

		test = extent.createTest("Login Test");
		System.out.println("Executing Login Test");
	}

	@Test
	public void isSkip() {

		test = extent.createTest("Skip Test");
		throw new SkipException("Skipping the test case");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			String failureLog = "TEST CASE FAILED";
			Markup markUp = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
			test.log(Status.FAIL, markUp);


			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see StackTrace"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");

			try {

				//ExtentManager.captureScreenshot();
				//ExtentManager.captureScreenshot(result.getMethod().getMethodName());
				
				String screenshotPath = ExtentManager.getScreenshot(driver, result.getName());
				//test.addScreenCaptureFromPath(screenshotPath);
				
				// adds screencast/video in extent report
				// extentTest.addScreencastFromPath(screenshotPath);

				test.fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (IOException e) {
				e.printStackTrace();
			}

	
		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + "  SKIPPED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			test.skip(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + "  PASSED" + "</b>";

			Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(markUp);

		}
		killBrowser();
	}

}
