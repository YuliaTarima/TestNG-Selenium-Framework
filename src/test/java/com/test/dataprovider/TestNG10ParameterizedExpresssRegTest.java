package com.test.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.util.Xls_Reader;

public class TestNG10ParameterizedExpresssRegTest extends TestBase {

	@Test
	public void validateCreateNewContact() {

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
			System.out.println("Row: " + rowNum);

			for (int colNum = 0; colNum < colCount; colNum++) {
				System.out.println("Column: " + colNum);

				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println(colNum + " -> " + cellValue);

				//collect elementNames and use to find Web Elements
				WebElement regElement = driver.findElement(By.name(elementNames.get(colNum)));
				System.out.println("RegElement is: " + elementNames.get(colNum));

				//separate case for country (handle Select)
				if (elementNames.get(colNum).equalsIgnoreCase("country")) {
					//System.out.println("Got Country");
					//String userCountry = reader.getCellData("RegTestData",  "country", rowNum);
					Select country = new Select(regElement);
					country.selectByVisibleText(cellValue);
				} else {

					regElement.clear();
					regElement.sendKeys(cellValue);
				}
			}
		}
	}
}