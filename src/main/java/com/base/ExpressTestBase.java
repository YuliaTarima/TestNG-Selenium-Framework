package com.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ExpressTestBase extends Base {

	@BeforeClass
	// @BeforeMethod
	public void setUp() {
		initialize("https://www.express.com/register", "FF");
	}

	@AfterClass
	// @AfterMethod
	public void tearDown() {
		killBrowser();
	}
}