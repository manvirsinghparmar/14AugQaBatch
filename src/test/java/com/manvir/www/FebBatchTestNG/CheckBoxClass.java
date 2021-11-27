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

public class CheckBoxClass {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://demoqa.com/checkbox");

	}

	@Test
	public void exampleOfImplicitWait() {

		WebElement expandIcon = wd.findElement(By.cssSelector("button[title='Expand all']"));

		expandIcon.click();
		WebElement notesCheckBox = wd.findElement(By.xpath("//span[contains(text(),'Notes')]"));
		notesCheckBox.click();

	}

	@AfterMethod
	public void tearDown() {
		// wd.quit();

	}

}
