package com.test.test11.paralleltest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParallelWithXml {
/*
 * To parallel test 
 * in several browsers
 * run this test through 
 * src\test\java\com\test\test11\paralleltest\parallel.xml
 */
    
    @Parameters({"browser"})
    @Test
    public void doLogin(String browser) throws InterruptedException {
	
	Date d = new Date();
	System.out.println(browser + "----" + d);
	Thread.sleep(2000);
    }

}
