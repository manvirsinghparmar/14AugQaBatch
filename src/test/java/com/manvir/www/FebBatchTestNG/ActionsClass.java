package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");

	}

	@Test
	public void rightClick() {
		String expectedSuccessMessage = "You have done a right click";

		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

		Actions action = new Actions(driver);
		
		//Context click method is used to perform right click
		action.contextClick(rightClickBtn).perform();

		WebElement successMessageWebelement = driver.findElement(By.id("rightClickMessage"));

		String actualSuccessMessageText = successMessageWebelement.getText();

		Assert.assertEquals(actualSuccessMessageText, expectedSuccessMessage);
	}

	@Test
	public void doubleClick() {
		String expectedSuccessMessage = "You have done a double click";

		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

		Actions action = new Actions(driver);

		//double click method is used to perform double click operation in Selenium
		action.doubleClick(doubleClickButton).perform();

		WebElement successMessageWebelement = driver.findElement(By.id("doubleClickMessage"));

		String actualSuccessMessageText = successMessageWebelement.getText();

		Assert.assertEquals(actualSuccessMessageText, expectedSuccessMessage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
