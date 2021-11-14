package com.manvir.www.FebBatchTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

	@Test(enabled = true)
	public void isRainingToday() {

		boolean isRaining = true;

		boolean isActuallyRaining = true;

		Assert.assertEquals(isActuallyRaining, isRaining);

	}
	
	@Test(enabled = false, priority = 1)
	public void isRainingToday2() {

		boolean isRaining = true;

		boolean isActuallyRaining = false;

		Assert.assertEquals(isActuallyRaining, isRaining, "Its raining");

	}
	
	
	

	@Test
	public void isGreater() {
		Assert.assertTrue(10 < 30);
	}
	
	
	@Test
	public void isLargest() {
		Assert.assertTrue(10>30, "10 is not greater than 30");
	}
}
