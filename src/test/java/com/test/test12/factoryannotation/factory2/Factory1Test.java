package com.test.test12.factoryannotation.factory2;

import org.testng.annotations.Test;

public class Factory1Test {
	
	@Test(enabled=false)
	public void Factory1Method_TC1() {
		System.out.println("Factory1Method TC1");
	}
	
	@Test
	public void Factory1Method_TC2() {
		System.out.println("Factory1Method TC2");
	}
	
	@Test
	public void Factory1Method_TC3() {
		System.out.println("Factory1Method TC3");
	}

}
