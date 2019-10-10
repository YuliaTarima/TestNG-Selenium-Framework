package com.util;

import java.util.ArrayList;

public class XLReaderDataProviderParameterization {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata.xlsx");

		int rowCount = reader.getRowCount("RegTestData");
		int colCount = reader.getColumnCount("RegTestData");
		// System.out.println(rowCount + " | " + colCount);

		// parameterization
		ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("============================================\n" + "Row: " + rowNum + "\n============================================");

			ArrayList<String> cols = new ArrayList<String>();
			for (int colNum = 0; colNum < colCount; colNum++) {
				//System.out.println("Column: " + colNum);

				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column: "+colNum + " -> " + cellValue);
				cols.add(cellValue);

				System.out.println("Array Cols: " + cols);
			}
			rows.add(cols);
			System.out.println("============================================\n" + "Array Rows: " + rows);
			//System.out.println(rows[0][0]);
		}
	}
}