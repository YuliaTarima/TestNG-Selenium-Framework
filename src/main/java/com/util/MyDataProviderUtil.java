package com.util;

import java.util.ArrayList;
import com.util.Xls_Reader;

public class MyDataProviderUtil {
	static Xls_Reader reader;

	public static ArrayList<ArrayList<Object>> getExcelData() {

		ArrayList<ArrayList<Object>> xcelData = new ArrayList<ArrayList<Object>>();

		try {
			reader = new Xls_Reader(
					System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int rowCount = reader.getRowCount("RegTestData");
		int colCount = reader.getColumnCount("RegTestData");
		// System.out.println(rowCount + " | " + colCount);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("============================================\n" + "Row: " + rowNum
					+ "\n============================================");

			ArrayList<Object> cols = new ArrayList<Object>();
			for (int colNum = 0; colNum < colCount; colNum++) {
				// System.out.println("Column: " + colNum);

				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column: " + colNum + " -> " + cellValue);
				cols.add(cellValue);

				System.out.println("Array Cols: " + cols);
			}
			xcelData.add(cols);
			System.out.println("============================================\n" + "Array Rows: " + xcelData);

		}
		//String eMail = xcelData.get(0)
				//firstName, lastName, passWord, userCountry
		return xcelData;
	}
}