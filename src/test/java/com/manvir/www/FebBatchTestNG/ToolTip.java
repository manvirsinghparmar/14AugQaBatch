package com.manvir.www.FebBatchTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");

	}

	@Test
	public void tooTip() throws InterruptedException {

		Actions action = new Actions(driver);

		WebElement toolTip = driver.findElement(By.id("toolTipButton"));

		action.moveToElement(toolTip).perform();
		
		Thread.sleep(3000);
		
		String attributeValue=toolTip.getAttribute("aria-describedby");
		
		Assert.assertEquals(attributeValue, "buttonToolTip");
		
		

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
