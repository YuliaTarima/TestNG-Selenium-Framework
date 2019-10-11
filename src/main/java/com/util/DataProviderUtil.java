package com.util;

import java.util.ArrayList;
import com.util.Xls_Reader;

public class DataProviderUtil {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getExcelData() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader(
					System.getProperty("user.dir") + "/src/main/java/com/testdata/ExpressRegistrationTestdata1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		int rowCount = reader.getRowCount("RegTestData");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

//			String currentTestMethod = reader.getCellData("RegTestData", "testCaseName", rowNum);
//			if (currentTestMethod.equals(testMethodName)) {
			System.out.println("============================================\n" + "Row: " + rowNum
					+ "\n============================================");
			
			// collect column values from excell
			String eMail = reader.getCellData("RegTestData", "email", rowNum);
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			String passWord = reader.getCellData("RegTestData", "password", rowNum);
			String userCountry = reader.getCellData("RegTestData", "country", rowNum);

			//add column values into object
			Object colValues[] = {eMail, firstName, lastName, passWord, userCountry};
			myData.add(colValues);
			// }
		}
		return myData;
	}
}