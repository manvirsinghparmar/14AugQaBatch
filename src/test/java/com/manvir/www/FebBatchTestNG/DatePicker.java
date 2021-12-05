package com.manvir.www.FebBatchTestNG;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/date-picker");

	}

	@Test
	public void datePicker() {

		String monthYear = "July 2022";
		String date = "15";

		// Click on the date picker button to display calendar
		WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));
		datePicker.click();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Wait for calendar to show up
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.react-datepicker__month-container")));

		// Find the month which is currently displayed
		WebElement currentMonth = driver.findElement(By.cssSelector("div.react-datepicker__current-month"));

		// Find the button to move to next month
		WebElement nextMonthButton = driver.findElement(By.cssSelector("button[aria-label='Next Month']"));

		// Keep clicking next month button unless the required month shows up
		while (!currentMonth.getText().equals(monthYear)) {
			nextMonthButton.click();

		}

		// Click on the date which u want to select
		driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--012")).click();

		// Get the attribute value and display it on console
		System.out.println("The date in date Picker is  " + datePicker.getAttribute("value"));

		/*
		 * String monthYear = "June 2022"; WebElement datePicker =
		 * driver.findElement(By.id("datePickerMonthYearInput")); datePicker.click();
		 * WebElement nextMonth =
		 * driver.findElement(By.xpath("//button[@aria-label='Next Month']"));
		 * WebElement currentMonth =
		 * driver.findElement(By.cssSelector("div.react-datepicker__current-month"));
		 * 
		 * while (!currentMonth.getText().equals(monthYear)) { nextMonth.click(); }
		 * 
		 * driver.findElement(By.xpath("//div[contains(text(),'15')]")).click();
		 * 
		 * String actualDate=datePicker.getAttribute("value");
		 * 
		 * System.out.println("The date selected is " + actualDate);
		 */

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
