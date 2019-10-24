package com.test.test10.parameterization.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestNG02MultipleDataProviders {

    @DataProvider(name = "dp1")
    /*
     * use overloaded Method m
     * that will take different number of arguments
     * depending on a condition
     */

    public static Object[][] getData(Method m) {
	Object[][] data = null;
	if (m.getName().equals("testLogin")) {
	    data = new Object[2][2];
	    data[0][0] = "yulia";
	    data[0][1] = "kdjfsk";
	    data[1][0] = "taisa";
	    data[1][1] = "jdfjkds";

	} else if (m.getName().equals("testUserRegDp1")) {
	    data = new Object[2][3];
	    data[0][0] = "yulia";
	    data[0][1] = "kdjfsk";
	    data[0][2] = "kdjfsk@gmail.com";
	    data[1][0] = "taisa";
	    data[1][1] = "jdfjkds";
	    data[1][2] = "kdjfsk@mail.ru";

	}
	return data;
    }

    @DataProvider(name = "dp2")
    public static Object[][] getData2() {
	Object[][] data = new Object[2][3];
	data[0][0] = "yulia";
	data[0][1] = "kdjfsk";
	data[0][2] = "kdjfsk@gmail.com";
	data[1][0] = "taisa";
	data[1][1] = "jdfjkds";
	data[1][2] = "kdjfsk@mail.ru";
	return data;
    }

}
