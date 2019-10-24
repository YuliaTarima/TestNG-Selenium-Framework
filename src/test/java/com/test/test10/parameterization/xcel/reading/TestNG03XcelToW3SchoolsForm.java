/*
 * 
 *submits test data obtained from xcel file into online web form fields
 * 
 */
package com.test.test10.parameterization.xcel.reading;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;

public class TestNG03XcelToW3SchoolsForm extends Base {

	@BeforeClass
    public void setUp() throws IOException {
		initializeUrl("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_form_submit");
		setUpXcelReader("/src/main/java/com/testdata/RegistrationTestdata.xlsx");
		System.out.println("\n##########\n"+"Before Class: setUp"+"\n##########\n");
	}

	@Test
	public void enterRegInfo() {
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
	
	@AfterClass
	public void tearDown() {
		killBrowser();
		System.out.println("\n##########\n"+"After Class: tearDown"+"\n##########\n");
	}
}