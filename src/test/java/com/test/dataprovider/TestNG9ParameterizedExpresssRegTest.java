package com.test.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.util.Xls_Reader;

public class TestNG9ParameterizedExpresssRegTest extends TestBase {

	@Test
	public void enterRegInfo() {
		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata.xlsx");

		int rowCount = reader.getRowCount("RegTestData");
		int colCount = reader.getColumnCount("RegTestData");
		
		List<String> elementNames = new ArrayList<String>();
		elementNames.add("loginName");
		elementNames.add("firstname");
		elementNames.add("lastname");
		elementNames.add("password");
		elementNames.add("country");

		// parameterization
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			for (int colNum = 0; colNum <= colCount; colNum++) {
				
				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Cell value1: " + cellValue);				
				
//				for (int elemNum = 0; elemNum < elementNames.size();elemNum++) {
					if (elementNames.get(colNum) == "country") {

						String userCountry = reader.getCellData("RegTestData", "country", rowNum);
						Select country = new Select(driver.findElement(By.name("country")));
						country.selectByVisibleText(userCountry);

					} else {
						WebElement regElement = driver.findElement(By.name(elementNames.get(colNum)));
						System.out.println("RegElement is: " + elementNames.get(colNum));

						regElement.clear();
						regElement.sendKeys(cellValue);
					}
					
					System.out.println("Cell value2: " + cellValue);
					
//				}



//				String eMail = reader.getCellData("RegTestData", "email", rowNum);
//				WebElement loginName = driver.findElement(By.name("loginName"));
//				loginName.clear();
//				loginName.sendKeys(eMail);
//
//				String firstName = reader.getCellData("RegTestData", "firstname", rowNum);				
//				WebElement fname = driver.findElement(By.name("firstname"));
//				fname.clear();
//				fname.sendKeys(firstName);
//
//				String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
//				WebElement lname = driver.findElement(By.name("lastname"));
//				lname.clear();
//				lname.sendKeys(lastName);
//
//				String passWord = reader.getCellData("RegTestData", "password", rowNum);
//				WebElement password = driver.findElement(By.name("password"));
//				password.clear();
//				password.sendKeys(passWord);
//
//				String userCountry = reader.getCellData("RegTestData",  "country", rowNum);
//				Select country = new Select(driver.findElement(By.name("country")));
//				country.selectByVisibleText(userCountry);

				// deal with reCaptcha
//				List<WebElement> isPresent = driver
//						.findElements(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"));
//				if (isPresent.size() > 0) {
//					driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"))
//							.click();
//				}
//				System.out.println("clicked recaptcha");
//
//				driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Create Account')]")).click();

			}
		}

	}
}