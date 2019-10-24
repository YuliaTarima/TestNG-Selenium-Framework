package com.test.test10.parameterization.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG01ParameterizationWithDataProvider {

    @Test(dataProvider = "getData")
    public void doLogin(String username, String password) {
	System.out.println("Username: " + username + "--- Password: " + password);
    }

    @DataProvider
    public Object[] getData() {
	
	Object[][] data = new Object[3][2];
	data[0][0] = "trainer@w2a@gmail.com";
	data[0][1] = "kjhdsflks";
	
	data[1][0] = "yt@gmail.com";
	data[1][1] = "phfkjd"; 
	
	data[2][0] = "tarima@gmail.com"; 
	data[2][1] = "hdfkjahdf";
	
	return data;
    }

}
