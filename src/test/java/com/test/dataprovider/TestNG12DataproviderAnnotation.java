package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.DataProviderUtil;

public class TestNG12DataproviderAnnotation extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = DataProviderUtil.getExcelData();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void expressRegPageTest(String eMail, String firstName, String lastName, String passWord,
			String userCountry) {

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