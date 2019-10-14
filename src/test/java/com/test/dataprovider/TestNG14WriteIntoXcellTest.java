package com.test.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.util.Xls_Reader;

public class TestNG14WriteIntoXcellTest extends TestBase {

	/*
	 * Simple 1D iteration example for .xlsx rows 
	 * it also writes "pass" status into .xlsx 
	 */
	@Test
	public void validateCreateNewContact() {

		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata2.xlsx");

		int rowCount = reader.getRowCount("RegTestData");
		
		//add sheet
		if (!reader.isSheetExist("HomePageTestData")) {
			reader.addSheet("HomePageTestData");
		}		
		reader.addColumn("RegTestData", "status");

		// parameterization
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			
			// collect column values
			String eMail = reader.getCellData("RegTestData", "email", rowNum);
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);// from where to start reading data
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);// sheet-column-row format
			String passWord = reader.getCellData("RegTestData", "password", rowNum);
			String userCountry = reader.getCellData("RegTestData", "country", rowNum);
			System.out.println("=======================\n" + "Row: " + rowNum + "\n=======================");

			//findBy column values
			WebElement loginName = driver.findElement(By.name("loginName"));
			System.out.println(eMail);
			loginName.clear();
			loginName.sendKeys(eMail);

			WebElement fname = driver.findElement(By.name("firstname"));
			System.out.println(firstName);
			fname.clear();
			fname.sendKeys(firstName);

			WebElement lname = driver.findElement(By.name("lastname"));
			System.out.println(lastName);
			lname.clear();
			lname.sendKeys(lastName);

			WebElement password = driver.findElement(By.name("password"));
			System.out.println(passWord);
			password.clear();
			password.sendKeys(passWord);

			Select country = new Select(driver.findElement(By.name("country")));
			System.out.println(userCountry);
			country.selectByVisibleText(userCountry);
			
			reader.setCellData("RegTestData", "status", rowNum, "Pass");
		}
	}
}