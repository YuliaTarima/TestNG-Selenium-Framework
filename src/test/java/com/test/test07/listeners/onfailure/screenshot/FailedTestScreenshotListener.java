package com.test.test07.listeners.onfailure.screenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedTestScreenshotListener extends BaseTest implements ITestListener {

	@Override 
	public void onTestFailure(ITestResult result){
		System.out.println("FAILED TEST: Taking a screenshot");
		screenshotFailedTest(result.getMethod().getMethodName());
	}
	 
}
