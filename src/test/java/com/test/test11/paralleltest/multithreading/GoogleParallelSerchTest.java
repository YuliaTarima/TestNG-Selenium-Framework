package com.test.test11.paralleltest.multithreading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.util.TestUtil;

public class GoogleParallelSerchTest extends Base {

	/*
	 * run this through 
	 * /TestngFramework/src/test/java/com/test/test11/paralleltest/multithreading/testng.xml
	 * 
	 */


	@BeforeMethod
	@Parameters({ "browser" })
	void prepareTest(String browser) throws IOException, InterruptedException {
		DriverFactory.getInstance().setDriver(BrowserFactory.createInstance(browser));
	}

	@Test
	@Parameters({ "search" })
	public void googleParallelSearchTest(String search) throws InterruptedException {
		System.out.println("googleParallelSearchTest");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//make sure you are running on different threads
		System.out.println("I am inside test 1. Thread: "+Thread.currentThread().getId());

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(search);
		//Thread.sleep(3000);
		searchBox.sendKeys(Keys.ENTER);
	}


	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().killDriver();//quits the particular test
	}

}
