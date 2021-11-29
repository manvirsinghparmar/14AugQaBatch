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

public class PhpTravelSignUp {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/signup");

	}

	@Test
	public void clickSignUpButton() {

		//Find all webelement
		WebElement firstName=driver.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lastName=driver.findElement(By.cssSelector("input[name='last_name']"));
		WebElement phoneNumber=driver.findElement(By.cssSelector("input[name='phone']"));
		WebElement email=driver.findElement(By.cssSelector("input[name='email']"));
		WebElement password=driver.findElement(By.cssSelector("input[name='password']"));
		WebElement acceptCookieButton=driver.findElement(By.cssSelector("div.cc-compliance button"));
		WebElement signUpButton = driver.findElement(By.cssSelector("div.form-group.mt-3 button"));
		
		//action on webelement
		
		//accept the cookie pop up
		acceptCookieButton.click();
		
		firstName.sendKeys("Manvir");
		lastName.sendKeys("Singh");
		phoneNumber.sendKeys("6472152994");
		email.sendKeys("msp@itm.com");
		password.sendKeys("Password@123");
		signUpButton.click();

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
