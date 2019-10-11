package com.test.dataprovider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.DataProviderUtil;
import com.util.Xls_Reader;


public class TestNG16ExcelWeb2Test extends TestBase{
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
    	
 //set up reader   	
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
        List<List<String>> values = new ArrayList<>();//xcelData

 //collect rows
        List<String> rows = new ArrayList<>();        
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("============================================\n" + "Row: " + rowNum
					+ "\n============================================");

//collect columns			
			List<String> cols = new ArrayList<>(); ;
			for (int colNum = 0; colNum < colCount; colNum++) {
				// System.out.println("Column: " + colNum);

				String cellValue = reader.getCellData("RegTestData", colNum, rowNum);
				System.out.println("Column: " + colNum + " -> " + cellValue);
				cols.add(cellValue);

				System.out.println("Array Cols: " + cols);
				rows.add(cellValue);
			}

			values.add(rows);	
			System.out.println("============================================\n" + "Values: " + values);
			process(webElementNames, values);

		}
		//String eMail = xcelData.get(0)
				//firstName, lastName, passWord, userCountry
		//return xcelData;
		

//        List<List<String>> values = new ArrayList<>();
//        List<String> row1 = new ArrayList<>();
//        row1.add("email1@gmai.com");
//        row1.add("Name1");
//        values.add(row1);
//
//        List<String> row2 = new ArrayList<>();
//        row2.add("email2@gmai.com");
//        row2.add("Name2");
//        values.add(row2);

        
    }


   private static void process(List<String> webElementNames, List<List<String>> values) {
       values.forEach(rowValues -> processRow(webElementNames, rowValues));
   }

   private static void processRow(List<String> webElementNames, List<String> rowValues) {
       Iterator<String> webElementNamesIt = webElementNames.iterator();
       Iterator<String> rowValuesIt = rowValues.iterator();
       while (webElementNamesIt.hasNext() && rowValuesIt.hasNext()) {
           String webElementName = webElementNamesIt.next();
           String value = rowValuesIt.next();
           processCell(webElementName, value);
       }
       System.out.println("Row processed: " + rowValues);
   }
   
   //set values into web elements here
   private static void processCell(String webElementName, String value) {
       System.out.println("Set webElementName '" + webElementName + "' to value '" + value + "'");
       
       // collect elementNames and use them to find Web Elements
  		WebElement regElement = driver.findElement(By.name(webElementName));
  		System.out.println("found regElement " + webElementName);
   }
    
    
    
    

 

 

		
//
//		// separate case for country (handle Select)
//		if (webElementName.equalsIgnoreCase("country")) {
//			Select country = new Select(regElement);
//			country.selectByVisibleText(webElementValue);
//
//		} else {
//			regElement.clear();
//			regElement.sendKeys(webElementValue);
//		}
        
    }