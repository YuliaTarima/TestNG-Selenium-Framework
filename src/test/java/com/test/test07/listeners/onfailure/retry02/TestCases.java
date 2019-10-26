package com.test.test07.listeners.onfailure.retry02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class TestCases extends Base {

	@BeforeMethod
	public void setUp() {
		setWebDriverManager("chrome", "https://www.linkedin.com/");
	}

	@Test(priority=1)
	public void verifyLoginPageText() {

		System.out.println("Verify login page test started");
		WebElement element = driver.findElement(By.cssSelector(".header>h2"));
		String headerText = element.getText();
		System.out.println("headerText is " + headerText);
		Assert.assertEquals(headerText, "Find the right job or internship for you");
	}

	@Test(priority=2)
	public void verifyForgotPasswordPage() {
		System.out.println("Verify Forgot password page test started");
		WebElement element = driver.findElement(By.linkText("Forgot your password?"));
		element.click();
		WebElement pageTextElement = driver.findElement(By.cssSelector(".flow-login-content>fieldset>h1"));
		String pageText = pageTextElement.getText();
		Assert.assertEquals(pageText, "Wrong text");
		//Assert.assertEquals(pageText, "Change your password");
	}
	
	@AfterMethod
	public void tearDown() {
		killBrowser();
	}
}
