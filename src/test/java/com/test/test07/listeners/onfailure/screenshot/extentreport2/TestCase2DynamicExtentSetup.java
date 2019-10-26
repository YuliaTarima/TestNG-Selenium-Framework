package com.test.test07.listeners.onfailure.screenshot.extentreport2;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class TestCase2DynamicExtentSetup extends Base {
	
	/* 
	 * Dynamic Extent Report setup
	 * through Listeners
	 * src/test/java/com/test/test07/listeners/onfailure/screenshot/extentreport2/ExtentListeners.java
	 * and ExtentManager util
	 * src/test/java/com/test/test07/listeners/onfailure/screenshot/extentreport2/ExtentManager.java
	 * 
	 * Run this test through
	 * src/test/java/com/test/test07/listeners/onfailure/screenshot/extentreport2/testng.xml
	 * 
	 * see the report file in 
	 * test-output/ExtentReportV4/*.html
	 */
	@BeforeMethod
	public void setUp() {
		setWebDriverManager("chrome");
	}
	
	@Test
	public void doLogin() {

		System.out.println("Executing Login Test");
		Assert.assertEquals(true, true);
	}

	@Test
	public void doUserReg() {

		Assert.fail("User Reg Test Failed");
	}

	@Test
	public void isSkip() {

		throw new SkipException("Skipping the test case");
	}
	
	@AfterMethod
	public void tearDown() {
		killBrowser();
	}

}
