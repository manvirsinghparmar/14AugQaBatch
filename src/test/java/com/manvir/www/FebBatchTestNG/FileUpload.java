package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

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
	public void fileUpload() {

		WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));

		uploadPicture.sendKeys("C:\\Users\\Owner\\Desktop\\16462916_10206987101349649_2483427888821378879_o.jpg");

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
