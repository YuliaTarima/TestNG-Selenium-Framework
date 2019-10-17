package com.test.test3.xcel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.base.ExpressTestBase;
import com.util.Xls_Reader;

public class TestNG11Parameterized2DExpresssRegTest extends ExpressTestBase {

	@Test
	public void validateCreateNewContact() {
		
/*
 * This is an example of iteration with 2D ArrayList		
 */

		List<String> elementNames = new ArrayList<String>();
		elementNames.add("loginName");
		elementNames.add("firstname");
		elementNames.add("lastname");
		elementNames.add("password");
		elementNames.add("country");

		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata1.xlsx");

		int rowCount = reader.getRowCount("RegTestData");
		int colCount = reader.getColumnCount("RegTestData");
		// System.out.println(rowCount + " | " + colCount);

		// parameterization
		// rewrite this as foreach as it is less prone to index errors and is more
		// efficient

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("=======================\n" + "Row: " + rowNum + "\n=======================");

			for (int colNum = 0; colNum < colCount; colNum++) {
				// System.out.println("Column: " + colNum);

				//collect columns from .xlsx
				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column (ColNum): " + colNum + " -> cellValue: " + cellValue);

				// collect elementNames and use them to find Web Elements
				WebElement regElement = driver.findElement(By.name(elementNames.get(colNum)));
				System.out.println("RegElement is: " + elementNames.get(colNum));

				// separate case for country (handle Select)
				if (elementNames.get(colNum).equalsIgnoreCase("country")) {
					Select country = new Select(regElement);
					country.selectByVisibleText(cellValue);

				} else {
					regElement.clear();
					regElement.sendKeys(cellValue);
				}
			}
			// deal with reCaptcha
//			List<WebElement> isPresent = driver
//					.findElements(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"));
//			if (isPresent.size() > 0) {
//				driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"))
//						.click();
//			}
//			System.out.println("clicked recaptcha");
//
//			driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Create Account')]")).click();
		}
	}
}