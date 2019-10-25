package com.test.test07.listeners.onfailure.mail;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class mailUtil extends TestBase {

    public static String mailscreenshotpath;
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
	    mailscreenshotpath = System.getProperty("user.dir") + "\\screenshot\\" + methodName
	            + "_" + year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_"
	            + sec + ".jpeg";
	    FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    // zip the reports
    public static void zip(String filepath) {
	try {
	    File inFolder = new File(filepath);
	    System.out.println(filepath);
//	zipPath = System.getProperty("user.dir")+"//zipreports//reports.zip";
//	File outFolder = new File(zipPath);    
	    File outFolder = new File("reports.zip");
	    ZipOutputStream out = new ZipOutputStream(
	            new BufferedOutputStream(new FileOutputStream(outFolder)));
	    BufferedInputStream in = null;
	    byte[] data = new byte[1000];
	    String files[] = inFolder.list();
	    for (int i = 0; i < files.length; i++) {
		in = new BufferedInputStream(
		        new FileInputStream(inFolder.getPath() + "/" + files[i]), 1000);
		out.putNextEntry(new ZipEntry(files[i]));
		int count;
		while ((count = in.read(data, 0, 1000)) != -1) {
		    out.write(data, 0, count);
		}
		out.closeEntry();
	    }
	    out.flush();
	    out.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
