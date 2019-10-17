package com.test.test3.xcel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.util.Xls_Reader;
import com.base.ExpressTestBase;

public class TestNG09XcelReaderExpressRegTest extends ExpressTestBase {

/*
 * This test can only collect the first row from .xlsx
 * does not have ways to iterate
 * see next file for the example of simple iteration
 */

	@Test
	public void ExpressRegPageTest() {

		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/RegistrationTestdata.xlsx");

		String eMail = reader.getCellData("RegTestData", "email", 2);
		String firstName = reader.getCellData("RegTestData", "firstname", 2);// from where to start reading data
		String lastName = reader.getCellData("RegTestData", "lastname", 2);//sheet-column-row format
		String passWord = reader.getCellData("RegTestData", "password", 2);
		String userCountry = reader.getCellData("RegTestData", "country", 2);

		WebElement loginName = driver.findElement(By.name("loginName"));
		loginName.clear();
		loginName.sendKeys(eMail);

		WebElement fname = driver.findElement(By.name("firstname"));
		fname.clear();
		fname.sendKeys(firstName);

		WebElement lname = driver.findElement(By.name("lastname"));
		lname.clear();
		lname.sendKeys(lastName);

		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(passWord);

		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText(userCountry);

		// deal with reCaptcha
		List<WebElement> isPresent = driver
				.findElements(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"));
		if (isPresent.size() > 0) {
			driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark' and role='presentation']"))
					.click();
		}
		System.out.println("clicked recaptcha");

		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Create Account')]")).click();
	}
}