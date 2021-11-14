package com.manvir.www.FebBatchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumTestCase {

	// Create a ref. variable of the webdriver interface
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		// Tell chrome which chrome driver version it need to use
		// Using webdriver manager
		WebDriverManager.chromedriver().setup();

		// Intialised it with Chrome driver class object
		wd = new ChromeDriver();

		// Get the URL of the website that we intend to test
		wd.get("https://demoqa.com/login");

		// maximise the browser window
		wd.manage().window().maximize();

	}

	@Test
	public void loginToToolsQA() {

		// Way to identify the webelements on a DOM
		WebElement userName = wd.findElement(By.cssSelector("#userName"));
		WebElement password = wd.findElement(By.cssSelector("#password"));
		WebElement loginButton = wd.findElement(By.cssSelector("#login"));

		// Enter text in the username and password input field
		userName.sendKeys("testuser");
		password.sendKeys("Password@123");

		// Click on login button
		loginButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement userNameOnLoggedInPage = wd.findElement(By.cssSelector("#userName-value"));

		//get the text from the webelement
		String getUserNameText = userNameOnLoggedInPage.getText();

		Assert.assertEquals("testuser", getUserNameText, "User name does not match");

	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
