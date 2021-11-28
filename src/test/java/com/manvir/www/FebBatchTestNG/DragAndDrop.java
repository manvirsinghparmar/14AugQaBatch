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

public class DragAndDrop {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable/");

	}

	@Test
	public void dragAndDrop() {
		String expectedTextOfTargetElement = "Dropped!";

		Actions action = new Actions(driver);

		WebElement sourceWebElement = driver.findElement(By.id("draggable"));
		WebElement targetWebElement = driver.findElement(By.id("droppable"));

		action.dragAndDrop(sourceWebElement, targetWebElement).perform();

		String getTargetElementText = targetWebElement.getText();

		Assert.assertEquals(getTargetElementText, expectedTextOfTargetElement);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
