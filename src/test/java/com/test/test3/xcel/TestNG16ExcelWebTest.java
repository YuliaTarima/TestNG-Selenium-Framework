package com.test.test3.xcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNG16ExcelWebTest {
    public static void main(String[] args) throws Exception {
        List<String> webElementNames = new ArrayList<>();
        webElementNames.add("email");
        webElementNames.add("name");

        List<List<String>> values = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("email1@gmai.com");
        row1.add("Name1");
        values.add(row1);

        List<String> row2 = new ArrayList<>();
        row2.add("email2@gmai.com");
        row2.add("Name2");
        values.add(row2);

        process(webElementNames, values);
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

    private static void processCell(String webElementName, String value) {
        System.out.println("Set '" + webElementName + "' to '" + value + "'");
    }
}