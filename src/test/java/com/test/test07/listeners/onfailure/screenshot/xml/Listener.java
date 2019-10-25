package com.test.test07.listeners.onfailure.screenshot.xml;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Base;

public class Listener extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed test --" + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		// capture screenshot on test failure
		String methodName = result.getName().toString().trim();

		try {
			Util.captureScreenshot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

}
