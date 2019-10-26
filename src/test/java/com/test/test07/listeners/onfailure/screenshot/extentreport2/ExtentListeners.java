package com.test.test07.listeners.onfailure.screenshot.extentreport2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners extends ExtentManager implements ITestListener {

	static Date timestamp = new Date();
	static String reportName = "Extent_" + timestamp.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String reportUrl = System.getProperty("user.dir") + "/test-output/ExtentReportV4/" + reportName;

	private static ExtentReports extent = ExtentManager.createInstance(reportUrl);

	// set each test case on a unique thread
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		testReport.set(test);
		
		//extent = new ExtentReports();
		extent.attachReporter(setReportStyle(reportUrl));

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(markUp);

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " FAILED";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, markUp);

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
						+ "Exception Occured: Click to see StackTrace" + "</font>" + "</b >" + "</summary>"
						+ excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
		try {

			 //ExtentManager.captureScreenshot();
			//ExtentManager.captureScreenshot(result.getMethod().getMethodName());

			String screenshotPath = ExtentManager.getScreenshot(driver, result.getName());
			//testReport.get().addScreenCaptureFromPath(screenshotPath);

			// adds screencast/video in extent report
			// extentTest.addScreencastFromPath(screenshotPath);

			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//
//			ExtentManager.captureScreenshot();
//			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
//					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " SKIPPED" + "</b>";
		Markup markUp = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		testReport.get().skip(markUp);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

}
