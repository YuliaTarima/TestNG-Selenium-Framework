package com.test.test07.listeners.onfailure.screenshot.xml;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.Base;

public class Util extends Base {

	public static String destination;
	// public static String zipPath;

	public static void captureScreenshot(String methodName) throws IOException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destination = System.getProperty("user.dir") + "/Screenshots/" + methodName + "_" + year + "_" + date
					+ "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
			FileUtils.copyFile(scrFile, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
