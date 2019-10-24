package com.test.test07.xmlcustomlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed test --" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Capturing Screenshot for the failed test --" + result.getName());
		
		//set up ReportNG
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		//Reporter adds input into testNg html report
		//adds a link to the screenshot of failed test
		Reporter.log("<a href=\"" + System.getProperty("user.dir")
				+ "/FailedTestsScreenshots/createContactsTest_20191021030701.png\" target =\"_blank\"alt=\"screenshot link\">Screenshot link</a>");
		Reporter.log("<br />");
		Reporter.log("<a href=\"" + System.getProperty("user.dir")
				+ "/FailedTestsScreenshots/createContactsTest_20191021030701.png\" target =\"_blank\"alt=\"screenshot link\">"
				+ "<img height=\"200\" width=\"200\"src=\"" + System.getProperty("user.dir")
				+ "/FailedTestsScreenshots/createContactsTest_20191021030701.png\"></a>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
