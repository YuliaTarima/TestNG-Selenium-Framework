package com.test.test10.parameterization.xml;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG02ParametersFromXML {
	/*
	 * Simple demonstration of Parameters annotation in TestNG xml file
	 * See how Parameters are set here: com\test\test10\parameterization\xml\testNG02Parameters.xml
	 * 
	 * This test will only run from com\test\test10\parameterization\xml\testNG01Parameters.xml
	 * otherwise will not have environment configuration variables/properties
	 * and will throw an error that parameters are missing
	 * */	
    
    @Parameters({"browser", "env"})
    @Test
    public void getBrowser(String browser, String environment) {
	System.out.println(browser +"----"+environment);
    }

}
