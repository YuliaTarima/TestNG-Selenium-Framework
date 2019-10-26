package com.test.test07.listeners.onfailure.screenshot.extentreport1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.base.Base;
import com.util.TestUtil;

public class Util extends Base {

	public static void screenshotFailedTest(String testMethodName) {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// creates src/FailedTestsScreenshots folder after execution
		// String filePath =
		// System.getProperty("user.dir")+"/FailedTestsScreenshots/failshot_"+this.getClass().getName()+"_"+date+".png";
		String filePath = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + testMethodName + "_" + date
				+ ".png";
		File destination = new File(filePath);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, see "src/ExtentReportsscreenshots" folder
		String fileUrl = System.getProperty("user.dir") + "/ExtentReportsScreenshots/" + screenshotName + date + ".png";
		File destination = new File(fileUrl);
		FileUtils.copyFile(source, destination);
		return fileUrl;
	}

}