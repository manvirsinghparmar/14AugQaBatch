package com.manvir.www.FebBatchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassSelenium {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/signup");

	}

	@Test
	public void fillUpSignUpForm() {

		WebElement dropDownMenu = driver.findElement(By.id("account_type"));
		Select select = new Select(dropDownMenu);

		// Select using index method
		select.selectByIndex(1);
		
		//Select using visible text
		
		select.selectByVisibleText("Agent");
		
		
		//Select by value
		select.selectByValue("customers");

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
