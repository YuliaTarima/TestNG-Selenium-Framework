package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.MyDataProviderUtil1;

public class TestNG14MyDataProviderIterators extends TestBase {

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = MyDataProviderUtil1.getExcelData();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void expressRegPageTest(String eMail, String firstName, String lastName, String passWord,
			String userCountry) {
		
		System.out.println("\n============================\n");
		System.out.println("@TEST DATA");
		System.out.println("\n============================\n");

		// collect web element names
		List<String> webElementNames = new ArrayList<String>();
		webElementNames.add("loginName");
		webElementNames.add("firstname");
		webElementNames.add("lastname");
		webElementNames.add("password");
		webElementNames.add("country");

		// collect web element values
		List<String> webElementValues = new ArrayList<String>();
		webElementValues.add(eMail);
		webElementValues.add(firstName);
		webElementValues.add(lastName);
		webElementValues.add(passWord);
		webElementValues.add(userCountry);

		Iterator<String> webElementNamesIt = webElementNames.iterator();
		Iterator<String> webElementValuesIt = webElementValues.iterator();
		
		while (webElementNamesIt.hasNext() && webElementValuesIt.hasNext()) {
			String webElementName = webElementNamesIt.next();
			String webElementValue = webElementValuesIt.next();
			WebElement regElement = driver.findElement(By.name(webElementName));
			
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++\n");
			System.out.println("Inside while: " + webElementName + " -> " + webElementValue);
			System.out.println("RegElemnt " + webElementName + " found = " + regElement);

			// separate case for country (handle Select)
			if (webElementName.equalsIgnoreCase("country")) {
				Select country = new Select(regElement);
				country.selectByVisibleText(webElementValue);

			} else {
				regElement.clear();
				regElement.sendKeys(webElementValue);
			}
		}
		System.out.println("Row processed: " + webElementNames + " -> " + webElementValues);
	}
}