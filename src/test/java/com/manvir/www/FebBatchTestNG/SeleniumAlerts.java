package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SeleniumAlerts {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

	}

	@Test
	public void acceptSimpleAlert() {

		WebElement alertButton = driver.findElement(By.id("alertButton"));
		alertButton.click();
		driver.switchTo().alert().accept();
	}

	@Test
	public void acceptConfirmationAlert() {
		WebElement alertButton = driver.findElement(By.id("confirmButton"));
		alertButton.click();
		driver.switchTo().alert().accept();
		WebElement confirmationElement = driver.findElement(By.id("confirmResult"));
		System.out.println("Message: " + confirmationElement.getText());

	}

	@Test
	public void dismissConfirmationAlert() {
		WebElement alertButton = driver.findElement(By.id("confirmButton"));
		alertButton.click();
		driver.switchTo().alert().dismiss();
		WebElement confirmationElement = driver.findElement(By.id("confirmResult"));
		System.out.println("Message: " + confirmationElement.getText());

	}

	@Test
	public void promptAlert() {
		String textToBePassed = "Pivot";
		WebElement alertButton = driver.findElement(By.id("promtButton"));
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(textToBePassed);
		alert.accept();

		WebElement promptMessage = driver.findElement(By.id("promptResult"));

		org.testng.Assert.assertTrue(promptMessage.getText().contains(textToBePassed));
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}
}
