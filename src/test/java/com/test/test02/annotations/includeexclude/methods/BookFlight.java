package com.test.test02.annotations.includeexclude.methods;

import org.testng.annotations.Test;

public class BookFlight {

	@Test
	public void bookFlight_RoundTrip_TC1() {
		System.out.println("bookFlight_RoundTrip_TC1");
	}

	@Test
	public void bookFlight_RoundTrip_TC2() {
		System.out.println("bookFlight_RoundTrip_TC2");
	}

	@Test
	public void bookFlight_OneWay_TC1() {
		System.out.println("bookFlight_OneWay_TC1");
	}

	@Test
	public void bookFlight_OneWay_TC2() {
		System.out.println("bookFlight_OneWay_TC2");
	}

}
