package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.DataProviderUtil;
import com.util.MyDataProviderUtil;
import com.util.MyDataProviderUtil1;
import com.util.Xls_Reader;

public class TestNG12MyDataProviderAnnotation extends TestBase {


	@DataProvider
	public Iterator<Object[]> getTestData() {

		ArrayList<Object[]> testData = MyDataProviderUtil1.getExcelData();
			return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void expressRegPageTest(String eMail, String firstName, String lastName, String passWord,
			String userCountry) {

		// public void ExpressRegPageTest(String data) {
		// System.out.println("getTestData: " + " -> " + data);

		List<String> elementNames = new ArrayList<String>();
		elementNames.add("loginName");
		elementNames.add("firstname");
		elementNames.add("lastname");
		elementNames.add("password");
		elementNames.add("country");

		// collect elementNames and use them to find Web Elements
//				WebElement regElement = driver.findElement(By.name(elementNames.get(colNum)));
//				
//
//				// separate case for country (handle Select)
//				if (elementNames.get(colNum).equalsIgnoreCase("country")) {
//					Select country = new Select(regElement);
//					country.selectByVisibleText(getTestData());
//
//				} else {
//					regElement.clear();
//					regElement.sendKeys(cellValue);
//				}
		
		// findBy column values
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
	}
}
