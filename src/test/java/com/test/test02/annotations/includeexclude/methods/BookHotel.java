package com.test.test02.annotations.includeexclude.methods;

import org.testng.annotations.Test;

public class BookHotel {

	@Test
	public void bookHotel__destinationCity_TC1() {
		System.out.println("bookHotel__destinationCity_TC1");
	}
	
	@Test
	public void bookHotel__checkinDate_TC2() {
		System.out.println("bookHotel__checkinDate_TC2");
	}
	
	@Test
	public void bookHotel__checkoutDate_TC3() {
		System.out.println("bookHotel__checkoutDate_TC3");
	}
}
