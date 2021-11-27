package com.manvir.www.FebBatchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingDriverViaSystemProperty {

	// Create a ref. variable of the webdriver interface
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {

		// Tell chrome which chrome driver version it need to use
		// Using webdriver manager
		 WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "F:\\Chrome Driver\\chromedriver.exe");

		// Intialised it with Chrome driver class object
		wd = new ChromeDriver();

		// Get the URL of the website that we intend to test
		wd.get("https://www.google.com/");

		// maximise the browser window
		wd.manage().window().maximize();

	}

	@Test
	public void sendKey() {

		// Way to identify the webelements on a DOM
		WebElement googleSearchBox = wd.findElement(By.cssSelector("input[type='text']"));
		googleSearchBox.sendKeys("Wiolet");
		
		String pageTitle=wd.getTitle();
		System.out.println("The page title is " + pageTitle);
		
		String currentURL=wd.getCurrentUrl();
		System.out.println("Current URL" + currentURL);
		
		

	}

	@Test
	public void clickSubmitButton() {
		WebElement googleSearchButton = wd.findElement(By.cssSelector("div.FPdoLc.lJ9FBc .gNO89b"));
		googleSearchButton.click();
	}

	@Test
	public void isLogoDisplayed() {
		WebElement googleLogo = wd.findElement(By.cssSelector("img.lnXdpd"));
		boolean isDisplayed=googleLogo.isDisplayed();
		
		System.out.println("is logo dispalyed : " + isDisplayed);
	}
	
	@Test
	public void submit() {
		WebElement googleSearchBox = wd.findElement(By.cssSelector("input[type='text']"));
		googleSearchBox.sendKeys("Audi");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		googleSearchBox.clear();
		
		googleSearchBox.sendKeys("BMW");
		WebElement googleSearchButton = wd.findElement(By.cssSelector("div.FPdoLc.lJ9FBc .gNO89b"));
		googleSearchButton.submit();
	
		
	}
	
	@Test
	public void getTextFromElement() {
		WebElement firstName=wd.findElement(By.id("userName-label"));
		
		String name=firstName.getText();
		
		System.out.println("The text is : " + name);
		
		Assert.assertEquals(name, "Full Name");
	}
	
	
	@Test
	public void clear() {

		// Way to identify the webelements on a DOM
		WebElement googleSearchBox = wd.findElement(By.cssSelector("input[type='text']"));
		googleSearchBox.sendKeys("Wiolet");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		googleSearchBox.clear();
		
		
		

	}
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wd.quit();
	}

}
