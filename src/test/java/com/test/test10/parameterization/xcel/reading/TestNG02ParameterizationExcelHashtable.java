package com.test.test10.parameterization.xcel.reading;

import java.util.Hashtable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.ExcelReader;


public class TestNG02ParameterizationExcelHashtable {

    public static ExcelReader excel = null;

    @Test(dataProvider = "getData")
    //Hashtable passed as a parameter this will get all values for column names as a key 
    public void testData(Hashtable<String, String> data) {
    	
    	//You can also get a single cell value from Hashtable through key
    	System.out.println(data.get("username"));
    }

    @DataProvider
    public static Object[][] getData() {
	//System.out.println("Working Directory = " + System.getProperty("user.dir"));
	if (excel == null) {
	    //excel = new ExcelReader("..\\xcelfiles\\testngdata.xlsx");
	    //excel = new ExcelReader("src/test/java/xcelfiles/testngdata.xlsx");
	    excel = new ExcelReader(	            
	    		System.getProperty("user.dir") + "/src/main/java/com/testdata/testngdata.xlsx"
	    		);
	}

	String sheetName = "loginTest";
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);

	Object[][] data = new Object[rows - 1][1];

	Hashtable<String, String> table = null;

	for (int rowNum = 2; rowNum <= rows; rowNum++) {

	    table = new Hashtable<String, String>();

	    for (int colNum = 0; colNum < cols; colNum++) {
		
	    //get keys from the first row
	    //let values increment 
		table.put(excel.getCellData(sheetName, colNum, 1),
		        excel.getCellData(sheetName, colNum, rowNum));
		data[rowNum - 2][0] = table;
	    }
	}

	return data;
    }
}
