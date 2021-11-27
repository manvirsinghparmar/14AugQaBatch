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

public class ImplicitWait {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");

	}

	@Test
	public void exampleOfImplicitWait() {

		WebElement contactLink = driver.findElement(By.id("userName"));
		WebElement header = driver.findElement(By.id("password"));
		contactLink.sendKeys("pivot_academy");
		header.sendKeys("Password@123");
		driver.findElement(By.id("login")).click();
		System.out.println(driver.findElement(By.id("userName-value")).getText());

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
