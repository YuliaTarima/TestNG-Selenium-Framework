package com.test.test10.parameterization.dataprovider;

import org.testng.annotations.Test;

public class TestNG02MultipleDataProvidersLogin {
    
    @Test(dataProviderClass=TestNG02MultipleDataProviders.class, dataProvider="dp1")
    public void testLogin(String username, String password) {
	System.out.println(username + "===" + password);
    }
    
    @Test(dataProviderClass=TestNG02MultipleDataProviders.class, dataProvider="dp1")
    public void testUserRegDp1(String fName, String lName, String email) {
	System.out.println(fName + "===" + lName + "===" + email);
    }
    
    @Test(dataProviderClass=TestNG02MultipleDataProviders.class, dataProvider="dp2")
    public void testUserRegDp2(String fName, String lName, String email) {
	System.out.println(fName + "===" + lName + "===" + email);
    }
    
}
