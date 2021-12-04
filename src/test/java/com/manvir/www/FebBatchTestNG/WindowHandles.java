package com.manvir.www.FebBatchTestNG;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

	}

	@Test
	public void exampleOfImplicitWait() {

		// Opening all the child window
		// driver.findElement(By.id("windowButton")).click();

		// Get the handle of Main page and mark it as Main window Handle
		String MainWindowHandle = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindowHandle);

		WebElement tabButton = driver.findElement(By.id("tabButton"));

		// Open a new Tab
		tabButton.click();

		// Get a list of all Window handles that are associated with that particular
		// instance of driver
		Set<String> s1 = driver.getWindowHandles();

		for (String windowHandle : s1) {
			System.out.println(windowHandle);
		}

		// Switch to parent Window Handle
		driver.switchTo().window(MainWindowHandle);

		// Open another tab
		tabButton.click();

		System.out.println("..........................................................................");

		// Get second list of all window handles
		Set<String> s2 = driver.getWindowHandles();

		for (String newWindowHandles : s2) {
			System.out.println(newWindowHandles);
		}

		// Compare List 1 and List 2 and switch to the latest tab that was opened by
		// comparing window handles of both list
		for (String windowHandleNew : s2) {
			for (String windowHandleOld : s1) {
				if (!windowHandleOld.equals(windowHandleNew)) {
					driver.switchTo().window(windowHandleNew);
				}

			}
		}

		System.out.println("Current window Handle is " + driver.getWindowHandle());

		String newlyOpenedTab = driver.getWindowHandle();

		WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));

		System.out.println("Text inside the newly opened tab is  : " + sampleHeading.getText());

		driver.switchTo().window(MainWindowHandle);

		tabButton.click();

		driver.switchTo().window(newlyOpenedTab);

		System.out.println("Text inside the newly opened tab is  2 : " + sampleHeading.getText());

		driver.switchTo().window(MainWindowHandle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
