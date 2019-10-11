package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.DataProviderUtil;
import com.util.MyDataProviderUtil;
import com.util.Xls_Reader;

public class TestNG12MyDataProviderAnnotation extends TestBase {
	
	@DataProvider
	public Iterator<ArrayList<Object>> getTestData() {
		ArrayList<ArrayList<Object>> testData = MyDataProviderUtil.getExcelData();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	
	public void ExpressRegPageTest(String data) {
		//String eMail, String firstName, String lastName, String passWord, String userCountry
		System.out.println("getTestData: " + " -> " + data);

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
			}
		}
