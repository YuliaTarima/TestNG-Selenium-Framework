package com.test.test02.annotations.enabled;

import org.testng.annotations.Test;

public class DisableTestCase {

	@Test(enabled = false)
	public void bookFlight_RoundTrip_TC1() {
		System.out.println("bookFlight_RoundTrip_TC1");
	}

	@Test
	public void bookFlight_RoundTrip_TC2() {
		System.out.println("bookFlight_RoundTrip_TC2");
	}

	@Test
	public void bookFlight_OneWay_TC3() {
		System.out.println("bookFlight_OneWay_TC3");
	}

	@Test
	public void bookFlight_OneWay_TC4() {
		System.out.println("bookFlight_OneWay_TC4");
	}

}
