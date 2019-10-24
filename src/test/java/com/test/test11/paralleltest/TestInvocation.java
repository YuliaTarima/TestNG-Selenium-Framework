package com.test.test11.paralleltest;

import org.testng.annotations.Test;

import com.base.Base;

public class TestInvocation extends Base {
    
    @Test(invocationCount=5, threadPoolSize=5)
    public void executeTest() {
	driver = setWebDriverManager("chrome");
	driver.get("http://google.com");
	System.out.println(driver.getTitle());
	driver.quit();
    }

}
