package com.test.dataprovider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.dataprovider.TestBase;

public class TestNG8DataProviderTest extends TestBase{

	@Test 
	public void regPageTest() {
		driver.findElement(By.linkText("register")).click();
	}
}
