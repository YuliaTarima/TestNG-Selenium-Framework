package com.test.test11.paralleltest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParallelWithDataProvider {
/*
 * Simple demonstration of parallel execution
 * through
 * @DataProvider(parallel = true)
 */

	@Test(dataProvider = "getData")
	public void doLogin(String browser) throws InterruptedException {

		Date date = new Date();
		System.out.println(browser + "----" + date);
		Thread.sleep(2000);
	}

	//@DataProvider
	@DataProvider(parallel = true)
	public Object[][] getData() {
		
		Object[][] data = new Object[2][1];
		data[0][0] = "chrome";
		data[1][0] = "firefox";
		return data;
	}
}
