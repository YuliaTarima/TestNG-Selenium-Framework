package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends Base {

	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeClass
    public void setUp() {
		initialize();
	}

	@AfterClass
	public void tearDown() {
		killBrowser();
	}
}