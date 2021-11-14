package com.manvir.www.FebBatchTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	
	@BeforeMethod
	public void eatEnergyBar() {
		System.out.println("Eating bar");
	}
	
	@Test
	public void danceWiolet() {
		System.out.println("Wiolet Dancing");
	}

	@Test
	public void danceJijo() {
		System.out.println("Jijo Dancing");
	}
	
	
	@AfterMethod
	public void drinkGatorade() {
		System.out.println("Drink energy drink");
	}

}
