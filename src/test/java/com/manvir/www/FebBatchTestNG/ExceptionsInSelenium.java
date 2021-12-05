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

public class ExceptionsInSelenium {

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
	public void noSuchElementException() {

		WebElement expandIcon = wd.findElement(By.xpath("//span[contains(text(),'Home1')]"));

		expandIcon.click();

	}

	@Test
	public void staleElementException() {
		WebElement expandIcon = wd.findElement(By.xpath("//span[contains(text(),'Home')]"));

		wd.navigate().refresh();

		WebElement expandIcon1 = wd.findElement(By.xpath("//span[contains(text(),'Home')]"));

		expandIcon1.click();
	}

	@Test
	public void noSuchFrameException() {
		wd.switchTo().frame("Jijo");
	}

	@Test
	public void noSuchAlertException() {
		wd.switchTo().alert().accept();
	}
	
	@Test
	public void noSuchWindowException() {
		wd.switchTo().window("Wiolet");
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
		
		//No such Session Exception-> Session ID is null. Using WebDriver after calling quit()?
		wd.get("https://demoqa.com/checkbox");

	}

}
