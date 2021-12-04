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

public class Iframes {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");

	}

	@Test
	public void switchToIframe() {

		// Switch to frame using index
		// driver.switchTo().frame(5);

		
		//Switch to frame
		driver.switchTo().frame(driver.findElement(By.id("frame1")));

		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		//Switch to main application or Window
		driver.switchTo().defaultContent();
		
		
		//Switch to second frame
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
