package com.manvir.www.FebBatchTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://guide.blazemeter.com/hc/en-us/articles/360017604877-Welcome-to-BlazeMeter-Docs");

	}

	@Test
	public void exampleForWebElements() {

		// get text of first element
		WebElement firstElement = driver.findElement(By.cssSelector("#categories>li"));

		System.out.println(firstElement.getText());

		List<WebElement> allElement1 = driver.findElements(By.cssSelector("#categories>li"));
		for (WebElement webElement : allElement1) {
			System.out.println(webElement.getText());

		}

		// click on a particular element based upon the text
		List<WebElement> allElement = driver.findElements(By.cssSelector("#categories>li"));

		for (int i = 0; i < allElement.size(); i++) {

			if (allElement.get(i).getText().equals("Blazemeter's API")) {

				allElement.get(i).click();
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
