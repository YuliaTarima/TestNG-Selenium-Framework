package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;
/*
 * Writes web table data into xcel file
 * for this to work, go to config.properties 
 * and change url to https://www.w3schools.com/html/html_tables.asp
 * 
 */
import com.util.Xls_Reader;

public class TestNG18WriteWebTableIntoXcel extends TestBase {
	public static Xls_Reader reader;

	@BeforeClass
	public void setUpXcelReader() throws IOException {
		//set up xcel file
		
		String fileUrl = System.getProperty("user.dir") + "/src/main/java/com/testdata/WtriteWebTableIntoXcel.xlsx";
		
		File xcelFile = new File(fileUrl); 
		if (!xcelFile.createNewFile()) { 
			System.out.println("\n++++++++++\n"+"xcelFile already exists"+"\n++++++++++\n");
		} else {
			System.out.println("\n++++++++++\n"+"New xcelFile created"+"\n++++++++++\n");
			//solve this: org.apache.poi.EmptyFileException: The supplied file was empty (zero bytes long)
		}
		
		// set up xcel Reader
			reader = new Xls_Reader(fileUrl);
	}

	@Test
	public void writeCompanyColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n"+"writeCompanyColumnIntoXcelTest"+"\n++++++++++++++++++++\n");
		
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
	}

	@Test
	public void writeContactColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n"+"writeContactColumnIntoXcelTest"+"\n++++++++++++++++++++\n");
		
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
	}

	@Test
	public void writeCountryColumnIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n"+"writeCountryColumnIntoXcelTest"+"\n++++++++++++++++++++\n");
		
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
	}

	@Test
	public void writeWholeTableIntoXcelTest() {
		System.out.println("\n++++++++++++++++++++\n"+"writeWholeTableIntoXcelTest"+"\n++++++++++++++++++++\n");

		// add sheet
		if (!reader.isSheetExist("writeWholeTableIntoXcel")) {
			reader.addSheet("writeWholeTableIntoXcel");
			System.out.println("Creted new sheet writeWholeTableIntoXcel");
		}
		// add columns
		reader.addColumn("writeWholeTableIntoXcel", "Company");
		reader.addColumn("writeWholeTableIntoXcel", "Contact");
		reader.addColumn("writeWholeTableIntoXcel", "Country");

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
				
				//write company data
				String companyXpath = xpathBeforeRow + rowNum + xpathAfterRow + "1" + xpathAfterCol;
				String companyName = driver.findElement(By.xpath(companyXpath)).getText();
				reader.setCellData("writeWholeTableIntoXcel", "Company", rowNum, companyName);
				
				//write contact data
				String contactXpath = xpathBeforeRow + rowNum + xpathAfterRow + "2" + xpathAfterCol;
				String contactName = driver.findElement(By.xpath(contactXpath)).getText();
				reader.setCellData("writeWholeTableIntoXcel", "Contact", rowNum, contactName);
				
				//write country data
				String countryXpath = xpathBeforeRow + rowNum + xpathAfterRow + "3" + xpathAfterCol;
				String countryName = driver.findElement(By.xpath(countryXpath)).getText();
				reader.setCellData("writeWholeTableIntoXcel", "Country", rowNum, countryName);
			}
		}
	}
}