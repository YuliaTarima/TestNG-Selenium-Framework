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
	 * 
	 * 
	 * see the report file in test-output/ExtentReportV4/*.html
	 */
//	@BeforeMethod
//	public void setUp() {
//		setWebDriverManager("chrome");
//	}

	//public WebDriver drievr = null;

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

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(search);
		//Thread.sleep(3000);
		searchBox.sendKeys(Keys.ENTER);
	}


	@AfterMethod
	public void tearDown() {
		//DriverFactory.getInstance().killDriver();//quits the particular test
		//driver.quit();//quits all browser window
	}

}
