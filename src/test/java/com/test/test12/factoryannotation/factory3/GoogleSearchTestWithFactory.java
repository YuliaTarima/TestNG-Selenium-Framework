package com.test.test12.factoryannotation.factory3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

/*
 * Simple demonstration 
 * of @Factory annotation
 * 
 * Run this from FactoryClass.java
 * 
 *  
 * @Factory marks a method as a factory
 * that returns objects
 * that will be used by TestNG
 * as Test classes
 * 
 * The method must return Object[]
 * 
 * Factories allow to create tests dynamically
 * analogy to invocation-count
 */

public class GoogleSearchTestWithFactory extends Base {

	@BeforeMethod
	public void setUp() {
		setWebDriverManager("chrome", "https://www.google.com/");
	}


	@Test
	public void googleSearchTest() throws InterruptedException {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("Flying monsters");
		// Thread.sleep(3000);
		searchBox.sendKeys(Keys.ENTER);
	}

	@AfterMethod
	public void tearDown() {
		killBrowser();
	}
}
