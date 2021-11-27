package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

	}

	@Test
	public void exampleOfImplicitWait() throws InterruptedException {

		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));

		WebElement firstRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		WebElement secondRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		WebElement thirdRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		
		
		firstName.sendKeys("Wiolet");
		lastName.sendKeys("Malik");
		userEmail.sendKeys("msp@it.com");
		
		firstRadioButton.click();
		
		Thread.sleep(3000);
		
		secondRadioButton.click();
		
		Thread.sleep(3000);
		
		thirdRadioButton.click();

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
