package com.test.test10.parameterization.xcel.writing;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;

public class WriteW3WebTableIntoXcelTest extends Base {
	
	
	@BeforeClass
    public void setUp() throws IOException {
		initialize("https://www.w3schools.com/html/html_tables.asp");
		setUpXcelReader("/src/main/java/com/testdata/WtriteWebTableIntoXcel.xlsx");
		System.out.println("\n##########\n"+"Before Class: setUp"+"\n##########\n");
	}

	@Test
	public void writeCompanyColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n" + "writeCompanyColumnIntoXcelTest" + "\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeCompanyColumnIntoXcel")) {
			reader.addSheet("writeCompanyColumnIntoXcel");
		}

		// add column
		reader.addColumn("writeCompanyColumnIntoXcel", "Company");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = rows.size();

		String xpathStart = "//*[@id='customers']/tbody/tr[";
		String xpathEnd = "]/td[1]";
		System.out.println("Total number of rows is " + rowCount);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String dynamicXpath = xpathStart + rowNum + xpathEnd;
			String companyName = driver.findElement(By.xpath(dynamicXpath)).getText();
			System.out.println("===================\n" + "companyName -> " + companyName);
			reader.setCellData("writeCompanyColumnIntoXcel", "Company", rowNum, companyName);
		}
		
		//collect time
		String endMillis = String.valueOf(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String endTime = endMillis+"\n"+date;
		System.out.println(dateFormat.format(date));
		//write time into column
		reader.addColumn("writeCompanyColumnIntoXcel", "FineshedAt");
		reader.setCellData("writeCompanyColumnIntoXcel", "FineshedAt", 4, endTime);
	}

	@Test
	public void writeContactColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n" + "writeContactColumnIntoXcelTest" + "\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeContactColumnIntoXcel")) {
			reader.addSheet("writeContactColumnIntoXcel");
		}

		// add column
		reader.addColumn("writeContactColumnIntoXcel", "Contact");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = rows.size();

		String xpathStart = "//*[@id='customers']/tbody/tr[";
		String xpathEnd = "]/td[2]";

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String dynamicXpath = xpathStart + rowNum + xpathEnd;
			String contactName = driver.findElement(By.xpath(dynamicXpath)).getText();
			System.out.println("===================\n" + "contactName -> " + contactName);
			reader.setCellData("writeContactColumnIntoXcel", "Contact", rowNum, contactName);
		}
		
		//collect time
		String endMillis = String.valueOf(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String endTime = endMillis+"\n"+date;
		System.out.println(dateFormat.format(date));
		//write time into column
		reader.addColumn("writeContactColumnIntoXcel", "FineshedAt");
		reader.setCellData("writeContactColumnIntoXcel", "FineshedAt", 4, endTime);
	}

	@Test
	public void writeCountryColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n" + "writeCountryColumnIntoXcelTest" + "\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeCountryColumnIntoXcel")) {
			reader.addSheet("writeCountryColumnIntoXcel");
		}

		// add column
		reader.addColumn("writeCountryColumnIntoXcel", "Country");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = rows.size();

		String xpathStart = "//*[@id='customers']/tbody/tr[";
		String xpathEnd = "]/td[3]";

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String dynamicXpath = xpathStart + rowNum + xpathEnd;
			String countryName = driver.findElement(By.xpath(dynamicXpath)).getText();
			System.out.println("===================\n" + "countryName -> " + countryName);
			reader.setCellData("writeCountryColumnIntoXcel", "Country", rowNum, countryName);
		}
		
		//collect time
		String endMillis = String.valueOf(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String endTime = endMillis+"\n"+date;
		System.out.println(dateFormat.format(date));
		//write time into column
		reader.addColumn("writeCountryColumnIntoXcel", "FineshedAt");
		reader.setCellData("writeCountryColumnIntoXcel", "FineshedAt", 4, endTime);
	}

	@Test
	public void writeTableIntoXcelSingleForLoopTest() {
		System.out.println(
				"\n++++++++++++++++++++\n" + "writeTableIntoXcelSingleForLoopTest" + "\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeWholeTableSingleFor")) {
			reader.addSheet("writeWholeTableSingleFor");
		}

		// add columns
		reader.addColumn("writeWholeTableSingleFor", "Company");
		reader.addColumn("writeWholeTableSingleFor", "Contact");
		reader.addColumn("writeWholeTableSingleFor", "Country");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = rows.size();

		String xpathStart = "//*[@id='customers']/tbody/tr[";
		String xpathMiddle = "]/td[";
		String xpathEnd = "]";

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String tableCellValue;
			
			// read company data
			String companyXpath = xpathStart + rowNum + xpathMiddle + "1" + xpathEnd;
			String companyName = driver.findElement(By.xpath(companyXpath)).getText();
			tableCellValue = driver.findElement(By.xpath(companyXpath)).getText();
			// write company data
			reader.setCellData("writeWholeTableSingleFor", "Company", rowNum, companyName);
			System.out.println("===================\n" + rowNum + " -> " + tableCellValue);

			// read contact data
			String contactXpath = xpathStart + rowNum + xpathMiddle + "2" + xpathEnd;
			String contactName = driver.findElement(By.xpath(contactXpath)).getText();
			tableCellValue = driver.findElement(By.xpath(contactXpath)).getText();
			// write contact data
			reader.setCellData("writeWholeTableSingleFor", "Contact", rowNum, contactName);
			System.out.println("===================\n" + rowNum + " -> " + tableCellValue);

			// read country data
			String countryXpath = xpathStart + rowNum + xpathMiddle + "3" + xpathEnd;
			String countryName = driver.findElement(By.xpath(countryXpath)).getText();
			tableCellValue = driver.findElement(By.xpath(countryXpath)).getText();
			// write country data
			reader.setCellData("writeWholeTableSingleFor", "Country", rowNum, countryName);
			System.out.println("===================\n" + rowNum + " -> " + tableCellValue);
		}
		
		//collect time
		String endMillis = String.valueOf(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String endTime = endMillis+"\n"+date;
		System.out.println(dateFormat.format(date));
		//write time into column
		reader.addColumn("writeWholeTableSingleFor", "FineshedAt");
		reader.setCellData("writeWholeTableSingleFor", "FineshedAt", 4, endTime);
	}

	@Test
	public void writeTableIntoXcelNestedForLoopTest() {
		System.out.println(
				"\n++++++++++++++++++++\n" + "writeTableIntoXcelNestedForLoopTest" + "\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeWholeTableNestedFor")) {
			reader.addSheet("writeWholeTableNestedFor");
			System.out.println("writeWholeTableNestedFor");
		}
		// add columns
		reader.addColumn("writeWholeTableNestedFor", "Company");
		reader.addColumn("writeWholeTableNestedFor", "Contact");
		reader.addColumn("writeWholeTableNestedFor", "Country");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = rows.size();

		String xpathBeforeRow = "//*[@id='customers']/tbody/tr[";
		String xpathAfterRow = "]/td[";
		String xpathAfterCol = "]";

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']//tr[" + rowNum + "]//td"));
			int colCount = cols.size();
			System.out.println("\n***\n" + "rowCount -> " + rowCount + " colCount -> " + colCount);

			for (int colNum = 1; colNum <= colCount; colNum++) {
				String dynamicXpath = xpathBeforeRow + rowNum + xpathAfterRow + colNum + xpathAfterCol;
				String tableCellValue = driver.findElement(By.xpath(dynamicXpath)).getText();

				System.out.println("===================\n" + rowNum + " -> " + colNum + " -> " + "tableCellValue -> "
						+ tableCellValue);

				// write company data
				String companyXpath = xpathBeforeRow + rowNum + xpathAfterRow + "1" + xpathAfterCol;
				String companyName = driver.findElement(By.xpath(companyXpath)).getText();
				reader.setCellData("writeWholeTableNestedFor", "Company", rowNum, companyName);

				// write contact data
				String contactXpath = xpathBeforeRow + rowNum + xpathAfterRow + "2" + xpathAfterCol;
				String contactName = driver.findElement(By.xpath(contactXpath)).getText();
				reader.setCellData("writeWholeTableNestedFor", "Contact", rowNum, contactName);

				// write country data
				String countryXpath = xpathBeforeRow + rowNum + xpathAfterRow + "3" + xpathAfterCol;
				String countryName = driver.findElement(By.xpath(countryXpath)).getText();
				reader.setCellData("writeWholeTableNestedFor", "Country", rowNum, countryName);
			}
		}
		//collect time
		String endMillis = String.valueOf(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String endTime = endMillis+"\n"+date;
		System.out.println(dateFormat.format(date));
		//write time into column
		reader.addColumn("writeWholeTableNestedFor", "FineshedAt");
		reader.setCellData("writeWholeTableNestedFor", "FineshedAt", 4, endTime);
	}
	
	@AfterClass
	public void tearDown() {
		killBrowser();
		System.out.println("\n##########\n"+"After Class: tearDown"+"\n##########\n");
	}
}