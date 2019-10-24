package com.test.test07.xmlcustomlisteners;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class TestFailureWithXmlListener extends BaseTest {
	
/*
 * Run this test from src\test\java\com\test\test07\xmlcustomlisteners\listeners.xml
 * 
 * see testNG report at test-output\index.html
 * see ReportNG report at test-output\html\index.html	
 * see extentReport at test-output\ExtentReportVersion4.html
 */
    
    @Test
    public void doLogin() {
	Assert.fail("Failing the login test");
	//System.out.println("Capture Screenshot only in case of a failure");

    }

}
