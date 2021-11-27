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

public class NavigationalCommands {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// load up the page on the browser
		driver.get("http://automationpractice.com/index.php");

	}

	@Test
	public void navigate() {

		System.out.println("Title of the landing is :" + driver.getTitle());

		WebElement contactUsLink = driver.findElement(By.id("contact-link"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contactUsLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Title of the contact us page : " + driver.getTitle());

		// Navigate me back to landing page
		driver.navigate().back();
		System.out.println("Title of the landing is :" + driver.getTitle());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Navigate to forward page
		driver.navigate().forward();
		System.out.println("Title of the contact us page : " + driver.getTitle());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Refresh a page
		driver.navigate().refresh();

		// direct navigation to a page
		driver.navigate().to("https://www.google.com");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
