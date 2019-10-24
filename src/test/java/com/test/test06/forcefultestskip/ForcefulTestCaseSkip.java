package com.test.test06.forcefultestskip;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class ForcefulTestCaseSkip {
/*
 * Simple example of forcefully skipping a test case
 * by using SkipException
 * 
 * can be used with if-else conditions
 */
    
    @Test
    public void isSkip() {
	
	throw new SkipException("Forcefully skipping the test as the condition is not met");	
    }

}
