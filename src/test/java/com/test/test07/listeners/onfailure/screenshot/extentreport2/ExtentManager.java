package com.test.test07.listeners.onfailure.screenshot.extentreport2;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.Base;

public class ExtentManager extends Base {

	private static ExtentReports extent;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;

	public static String screenshotPath;
	public static String screenshotName;
	public static String destinationUrl;
	
	public static ExtentHtmlReporter setReportStyle(String reportUrl) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportUrl);

		// set look and feel
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("InCodingGirls Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		String css = ".r-img {width: 100%;} .screenshots > li img {border: 1px solid #ff0000;} .step-details > img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);
		
		return htmlReporter;
	}

	public static ExtentReports createInstance() {
		// set the reports folder
		String reportUrl = System.getProperty("user.dir") + "/test-output/ExtentReportV4.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportUrl);

		// set look and feel
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("InCodingGirls Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		String css = ".r-img {width: 100%;} .screenshots > li img {border: 1px solid #ff0000;} .step-details > img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// add any details to report in key-value format
		extent.setSystemInfo("SDET", "InCoding Girls");
		extent.setSystemInfo("Orgainzation", "InCodingGirls");
		extent.setSystemInfo("Build No", "ICG-1234");

		return extent;
	}

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		String css = ".r-img {width: 100%;} .screenshots > li img {border: 1px solid #ff0000;}";
		htmlReporter.config().setCSS(css);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("SDET", "InCoding Girls");
		extent.setSystemInfo("Orgainzation", "InCodingGirls");
		extent.setSystemInfo("Build No", "ICG-1234");

		return extent;
	}

	public static String captureScreenshot() {

		// Date d = new Date();
		// screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		String timestamp = year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec;

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationUrl = System.getProperty("user.dir") + "/Screenshots/" + timestamp + ".jpeg";
		File destination = new File(destinationUrl);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationUrl;
	}

	// gets methodName from ITestResult result as result.getMethod().getMethodName()
	public static String captureScreenshot(String methodName) throws IOException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		String timestamp = year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String destinationUrl = System.getProperty("user.dir") + "/Screenshots/" + methodName + "_" + timestamp
					+ ".jpeg";
			FileUtils.copyFile(scrFile, new File(destinationUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationUrl;
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		String timestamp = year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destinationUrl = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + timestamp + ".png";
		FileUtils.copyFile(scrFile, new File(destinationUrl));
		return destinationUrl;
	}
}
