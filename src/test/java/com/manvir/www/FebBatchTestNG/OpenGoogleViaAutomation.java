package com.manvir.www.FebBatchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogleViaAutomation {

	WebDriver driver;
	
	@BeforeMethod
	public void launchChrome() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	@Test
	public void getTheTitleOfThePage() {
		driver.get("https://www.google.ca/");
		WebElement input=driver.findElement(By.cssSelector("input.gLFyf"));
		input.sendKeys("Wiolet");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Title of the Page is .............        " + driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
