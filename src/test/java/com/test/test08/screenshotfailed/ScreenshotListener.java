package com.test.test08.screenshotfailed;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener extends ScreenshotTestBase implements ITestListener {

	@Override 
	public void onTestFailure(ITestResult result){
		System.out.println("FAILED TEST: Taking a screenshot");
		screenshotFailedTest(result.getMethod().getMethodName());
	}
	 
}
