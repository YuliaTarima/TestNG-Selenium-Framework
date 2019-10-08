/*
 * 
 * To run this class, change url in config file at
 * com\test\dataprovider\config.properties
 * 
 */
package com.test.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.util.Xls_Reader;

public class TestNG8DataProviderW3SchoolsTest extends TestBase{
	

	@Test
	public void enterRegInfo() {
		
		Xls_Reader reader = new Xls_Reader( System.getProperty("user.dir") + "/src/main/java/com/testdata/RegistrationTestdata.xlsx");

		String firstName = reader.getCellData("RegTestData", "firstname", 2);//from where to start reading data
		//System.out.println(firstName);
		
		String lastName = reader.getCellData("RegTestData", "lastname", 2);//from where to start reading data
		//System.out.println(lastName);
		
		driver.switchTo().frame("iframeResult");
		WebElement fname = driver.findElement(By.name("FirstName"));
		fname.clear();
		fname.sendKeys(firstName);
		
		WebElement lname = driver.findElement(By.name("LastName"));
		lname.clear();
		lname.sendKeys(lastName);
		

		//driver.findElement(By.xpath("//input[contains(@value, 'Submit')]")).click();
		driver.findElement(By.xpath("//input[@value='Submit' and @type='submit']")).click();
		//driver.findElement(By.cssSelector("input[value='Submit'][type='submit']")).click();
	}
	
}
