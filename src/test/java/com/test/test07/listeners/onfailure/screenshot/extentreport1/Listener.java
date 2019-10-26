package com.test.test07.listeners.onfailure.screenshot.extentreport1;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Base;

public class Listener extends Base implements ITestListener {

	@Override 
	public void onTestFailure(ITestResult result){
		System.out.println("FAILED TEST: Taking a screenshot");
		Util.screenshotFailedTest(result.getMethod().getMethodName());
	}
	 
}
