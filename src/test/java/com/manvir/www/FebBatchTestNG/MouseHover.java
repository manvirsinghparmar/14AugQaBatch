package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu/");

	}

	@Test
	public void mouseHover() {

		Actions action = new Actions(driver);

		WebElement menuItem = driver.findElement(By.cssSelector("#nav li:nth-of-type(2)"));

		action.moveToElement(menuItem).perform();

		WebElement firstElementOfTheList = driver
				.findElement(By.cssSelector("#nav li:nth-of-type(2)>ul li:first-of-type"));

		String firstElementTextString = firstElementOfTheList.getText();

		Assert.assertEquals(firstElementTextString, "Sub Item");

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
