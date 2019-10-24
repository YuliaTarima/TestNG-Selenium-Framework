package com.test.test03.softassertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;

public class TestCase2SoftAssert  extends BaseTest {

    @Test(groups="smoke")
    public void validateElements() {

	System.out.println("Beginning");

	SoftAssert softAssert = new SoftAssert();

	System.out.println("Validating title");
	String expectedTitle = "Yahoo.com";// xcel
	String actualTitle = "Gmail.com";// selenium
	// Assert.assertEquals(expectedTitle, actualTitle);
	softAssert.assertEquals(expectedTitle, actualTitle);

	System.out.println("Validating text box presence");
	softAssert.assertTrue(false, "Text box not found");

	System.out.println("Validating image");
	softAssert.assertEquals(true, true, "Image validation failed");
	
	System.out.println("Validating button");
	softAssert.fail("Forcefully failing the test as the condition is not met");
	
	System.out.println("Ending");
	softAssert.assertAll();
    }

}
