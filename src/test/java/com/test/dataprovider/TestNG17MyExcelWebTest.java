package com.test.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.util.Xls_Reader;

public class TestNG17MyExcelWebTest extends TestBase {
	static Xls_Reader reader;
	static List<String> webElementNames;

	public static void main(String[] args) throws Exception {

//get a list of web elements on a page   
		webElementNames = new ArrayList<>();
		webElementNames.add("loginName");
		webElementNames.add("firstname");
		webElementNames.add("lastname");
		webElementNames.add("password");
		webElementNames.add("country");

		// set up reader
		try {
			reader = new Xls_Reader(
					System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("RegTestData");
		int colCount = reader.getColumnCount("RegTestData");
		// System.out.println(rowCount + " | " + colCount);

//get all xcel Data
		List<List<List<String>>> xcelTable = new ArrayList<>();

		// collect rows
		List<List<String>> rows = new ArrayList<>();
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("=========================\n" + "Row: " + rowNum + "\n========================");
			// collect columns values and add to cols
			List<String> cols = new ArrayList<>();
			for (int colNum = 0; colNum < colCount; colNum++) {
				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column: " + colNum + " -> cellValue: " + cellValue);
				cols.add(cellValue);

			}
			rows.add(cols);
			System.out.println("===================\n" + "Cols: " + cols + "\n");
		}

		xcelTable.add(rows);
		System.out.println("===================\n" + "Rows: " + rows + "\n");
		process(webElementNames, xcelTable);
	}

	private static void process(List<String> webElementNames, List<List<List<String>>> values) {
		values.forEach(allRows -> processRow(webElementNames, allRows));
	}

	private static void processRow(List<String> webElementNames, List<List<String>> allRows) {
		Iterator<List<String>> allRowsIt = allRows.iterator();
		while (allRowsIt.hasNext()) {
			List<String> webElementValues = allRowsIt.next();
			processCell(webElementNames, webElementValues);
		}
		System.out.println("Row processed (rowValuesList): " + allRows);
	}

	// set values into web elements here
	private static void processCell(List<String> webElementNames, List<String> webElementValues) {
		Iterator<String> webElementNamesIt = webElementNames.iterator();
		Iterator<String> webElementValueIt = webElementValues.iterator();
		String webElValue;
		while (webElementNamesIt.hasNext() && webElementValueIt.hasNext()) {
			String webElementName = webElementNamesIt.next();
			webElValue = webElementValueIt.next();
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++\n");
			System.out.println("Inside while: " + webElementName + " -> " + webElValue);
			System.out.println("Set webElementName '" + webElementName + "' to value '" + webElValue + "'");
		}
	}
}