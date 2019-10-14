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

public class TestNG13MyDataProviderAnnotation extends TestBase {

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = MyDataProviderUtil1.getExcelData();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void expressRegPageTest(String eMail, String firstName, String lastName, String passWord,
			String userCountry) {

		List<String> elementNames = new ArrayList<String>();
		elementNames.add("loginName");
		elementNames.add("firstname");
		elementNames.add("lastname");
		elementNames.add("password");
		elementNames.add("country");

		// Iterator to traverse the list elementNames
		Iterator<String> elementsIterator = elementNames.iterator();

		// match elementsIterator to xcel data
		while (elementsIterator.hasNext() ) {

			// get element name
			String elementName = elementsIterator.next();
			WebElement regElement = driver.findElement(By.name(elementName));
			System.out.print("RegElemnt " + elementName + " found = " + regElement);
			System.out.println();

			String elementValue;
		
			switch (elementName) {
			case "country":
				elementValue = userCountry;
				Select country = new Select(regElement);
				country.selectByVisibleText(elementValue);
				break;
			case "loginName":
				elementValue = eMail;
				regElement.clear();
				regElement.sendKeys(elementValue);
				break;
			case "firstname":
				elementValue = firstName;
				regElement.clear();
				regElement.sendKeys(elementValue);
				break;
			case "lastname":
				elementValue = lastName;	
				regElement.clear();
				regElement.sendKeys(elementValue);
				break;
			case "password":
				elementValue = passWord;		
				regElement.clear();
				regElement.sendKeys(elementValue);
				break;
			}
			

//           //collect returned xcel data values in correct vars
//			if (elementName.equalsIgnoreCase("loginName")) {
//				regElement.clear();
//				regElement.sendKeys(eMail);
//			} else if (elementName.equalsIgnoreCase("firstname")) {
//					regElement.clear();
//					regElement.sendKeys(firstName);
//			} else if (elementName.equalsIgnoreCase("lastname")) {
//				regElement.clear();
//				regElement.sendKeys(lastName);
//			} else if (elementName.equalsIgnoreCase("password")) {
//				regElement.clear();
//				regElement.sendKeys(passWord);
//
//				// separate case for country (handle Select)
//			} else if (elementName.equalsIgnoreCase("country")) {
//				Select country = new Select(regElement);
//				country.selectByVisibleText(userCountry);
//			}
		}
	}
}