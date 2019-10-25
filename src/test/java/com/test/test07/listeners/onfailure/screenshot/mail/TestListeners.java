package com.test.test07.listeners.onfailure.screenshot.mail;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.base.Base;

public class TestListeners extends Base implements ITestListener {

    public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult result) {
	System.out.println("Passed test --" + result.getName());

    }

//    public void onTestFailure(ITestResult result) {
//	// System.out.println("Capturing Screenshot for the failed test --" +
//	// result.getName());
//	System.setProperty("org.uncommons.reportng.escape-output", "false");
//	Reporter.log(
//	        "<a href=\"C:\\Users\\yulia\\eclipse-workspace\\MavenSeleniumProject\\screenshots\\Wed_Jul_03_14_17_33_PDT_2019.jpg\" target =\"_blank\"alt=\"screenshot link\">Screenshot link</a>");
//	Reporter.log("<br />");
//	Reporter.log(
//	        "<a href=\"C:\\Users\\yulia\\eclipse-workspace\\MavenSeleniumProject\\screenshots\\Wed_Jul_03_14_17_33_PDT_2019.jpg\" target =\"_blank\"alt=\"screenshot link\"><img height=\"200\" width=\"200\"src=\"C:\\Users\\yulia\\eclipse-workspace\\MavenSeleniumProject\\screenshots\\Wed_Jul_03_14_17_33_PDT_2019.jpg.\"></a>");
//    }

    public void onTestFailure(ITestResult result) {

	String methodName = result.getName().toString().trim();

	try {
	    testUtil.captureScreenshot(methodName);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
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

	testUtil.zip(System.getProperty("user.dir") + "\\screenshot");
	monitoringMail mail = new monitoringMail();
	
	try {
	    mail.sendMail(MailConfig.server, MailConfig.from, MailConfig.to, MailConfig.subject,
	            MailConfig.messageBody, MailConfig.attachmentPath, MailConfig.attachmentName);
	} catch (AddressException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (MessagingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
