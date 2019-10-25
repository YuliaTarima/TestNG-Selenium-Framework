package com.test.test07.listeners.onfailure.screenshot.mail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotZipMailTest extends TestBase {
    
    @Test(priority=1)
    public void doLogin(){
	
	driver.findElement(By.id("identifierId")).sendKeys("russianusa.tarima@gmail.com");
	System.out.println("Was able to enter email");

	driver.findElement(By.id("identifierNext")).click();
	System.out.println("Was able to click on the login next button");
    }
    
    @Test(priority=2)
    public void composeEmail() {
	Assert.fail("Error in composing email");
    }

}
