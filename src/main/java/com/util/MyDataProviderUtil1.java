package com.util;

import java.util.ArrayList;
import java.util.List;

import com.util.Xls_Reader;

/*
 * Dynamically collects all rows and columns in ArrayList<Object[]>
 * list this method as data provider
 * and add the needed amount of parameters to the test method
 */

public class MyDataProviderUtil1 {
	static Xls_Reader reader;
	

	public static ArrayList<Object[]> getExcelData() {
		
		//get all xcel Data
        ArrayList<Object[]> xcelData = new ArrayList<>();
		//ArrayList<Object[]> xcelData = new ArrayList<>();

        //set up xcel Reader
		try {
			reader = new Xls_Reader(
					System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//get rows
		int rowCount = reader.getRowCount("RegTestData");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("============================================\n" + "Row: " + rowNum
					+ "\n============================================");
			List<String> rowContents = new ArrayList<>();
			//get column values
			int colCount = reader.getColumnCount("RegTestData");
			//List<String> cols = new ArrayList<>();
			//ArrayList<String> cols = new ArrayList<String>();
			for (int colNum = 0; colNum < colCount; colNum++) {
				// System.out.println("Column: " + colNum);

				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column String: " + colNum + " -> " + cellValue);
				//cols.add(cellValue);
				//System.out.println("Array Cols: " + cols);
				
				//add cellValues to Object array
				//Object rowContents[] = new Object[] {};
				rowContents.add(cellValue);
			}
			//xcelData.add(cols);
			//System.out.println("============================================\n" + "Array Rows: " + xcelData);
			
			//add column values into object
			Object rowContentsObj[] = rowContents.toArray();
//			myData.add(rowContents);
//			System.out.println("rowContents: " + eMail+", "+firstName+", "+lastName+", "+passWord+", "+userCountry);
			xcelData.add(rowContentsObj);
			System.out.println("============================================\n" + "Array Rows: " + xcelData);
		}
		// String eMail = xcelData.get(0)
		// firstName, lastName, passWord, userCountry
		return xcelData;
	}
}