package com.manvir.www.FebBatchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");

	}

	@Test
	public void exampleOfExplicitWait() {

		WebElement contactLink = driver.findElement(By.id("userName"));
		WebElement header = driver.findElement(By.id("password"));
		contactLink.sendKeys("pivot_academy");
		header.sendKeys("Password@123");
		driver.findElement(By.id("login")).click();

		//Explicit Wait 
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName-value")));

		WebElement userName = driver.findElement(By.id("userName-value"));

		System.out.println("Username is  " + userName.getText());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
