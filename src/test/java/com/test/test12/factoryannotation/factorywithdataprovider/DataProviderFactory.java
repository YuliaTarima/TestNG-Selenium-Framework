package com.test.test12.factoryannotation.factorywithdataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderFactory {
	
	private String dataString;
	private int dataInt;
	
	@Factory
	(dataProvider="dataMethod") 
	public DataProviderFactory(String dpString, int dpint){
		this.dataString = dpString;
		this.dataInt = dpint;
	}
	
	@DataProvider
	public static Object[][] dataMethod(){
		return new Object[][] {
			{"firstString", 1},
			{"secondString", 2}
		};
	}

	@Test
	public void firstMethodTest() {
		System.out.println("firstMethodTest: dataString -> "+dataString+"; dataInt -> "+dataInt);
	}
	
	@Test
	public void secondMethodTest() {
		System.out.println("secondMethodTest: dataString -> "+dataString+"; dataInt -> "+dataInt);
	}
}
