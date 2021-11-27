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
		wd.get("https://demoqa.com/automation-practice-form");

		// maximise the browser window
		wd.manage().window().maximize();

	}

	@Test
	public void loginToToolsQA() {

		// Way to identify the webelements on a DOM
		WebElement firstName = wd.findElement(By.id("firstName"));
		WebElement lastName=wd.findElement(By.id("lastName"));
		WebElement emailInput=wd.findElement(By.id("userEmail"));
		WebElement subject=wd.findElement(By.cssSelector("div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3"));
		WebElement currentAddress=wd.findElement(By.xpath("//textarea[@id='currentAddress']"));
		
		firstName.sendKeys("Wiolet");
		lastName.sendKeys("Malik");
		emailInput.sendKeys("abc@gmail.com");
		subject.sendKeys("Learning automation");
		currentAddress.sendKeys("Canada");
	
		

	}


}
