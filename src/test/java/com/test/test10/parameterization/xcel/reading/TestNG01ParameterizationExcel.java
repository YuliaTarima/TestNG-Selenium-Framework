package com.test.test10.parameterization.xcel.reading;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.ExcelReader;

public class TestNG01ParameterizationExcel {

    public static ExcelReader excel = null;

    @Test(dataProvider = "getData")
    public void testData(String username, String password, String is_correct) {
	System.out.println(
	        "Username: " + username + "| Password: " + password + "| isCorrect: " + is_correct);
    }

    @DataProvider
    public static Object[][] getData() {

	if (excel == null) {
	    excel = new ExcelReader(	            
	    		System.getProperty("user.dir") + "/src/main/java/com/testdata/testngdata.xlsx"
	    		);
	    //excel = new ExcelReader("..\\xcelfiles\\testngdata.xlsx");
	    //excel = new ExcelReader("/TestNGLearning/src/test/java/xcelfiles/testngdata.xlsx");
	}

	String sheetName = "loginTest";
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);

	Object[][] data = new Object[rows-1][cols];

	for (int rowNum = 2; rowNum <= rows; rowNum++) {
	    for (int colNum = 0; colNum < cols; colNum++) {
		data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
	    }
	}

	return data;
    }
}
