package com.test.test02.annotations.includeexclude.groups;

import org.testng.annotations.Test;

public class TestBelongsToSingleGroup {
	
	@Test(groups={"sanity-group"})
	public void testOne() {
		System.out.println("Test belongs to sanity group");
	}
	
	@Test(groups={"smoke-group"})
	public void testTwo() {
		System.out.println("Test does not belong to sanity group");
	}
	
	@Test(groups={"sanity-group", "smoke-group"})
	public void testThree() {
		System.out.println("Test belongs to sanity group and smoke group");
	}
	
	@Test(groups={"sanity-group", "regression-group"})
	public void testFour() {
		System.out.println("Test belongs to sanity group and regression group");
	}

}
