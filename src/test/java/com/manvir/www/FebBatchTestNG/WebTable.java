package com.manvir.www.FebBatchTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	WebDriver driver;

	@BeforeMethod
	void Setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	void login() {

		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		List<WebElement> noOfColumns = driver.findElements(By.xpath("//table[@class='dataTable']//tr/th"));

		System.out.println("The no. of Rows " + noOfRows.size() + " ... " + "The no. of colums " + noOfColumns.size());

		String beforeXpath = "//table[@class='dataTable']//tbody//tr[";
		String afterXapth = "]//td[";

		for (int i = 1; i <= noOfRows.size(); i++) {
			for (int j = 1; j <= noOfColumns.size(); j++) {
				WebElement finalElement = driver.findElement(By.xpath(beforeXpath + i + afterXapth + j + "]"));
				if(finalElement.getText().equals("Jet Airways")) {
					finalElement.click();
				}
				
			}
		}

		/*
		 * String beforePath = "//table[@class='dataTable']//tbody//tr["; String
		 * afterPath = "]//td[";
		 * 
		 * List<WebElement> tableElementsInRow =
		 * driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		 * List<WebElement> totalNoOfColumn =
		 * driver.findElements(By.xpath("//table[@class='dataTable']//tr//th"));
		 * 
		 * System.out.println("The Row size is: " + tableElementsInRow.size() + ".... "
		 * + "The colum size is : " + totalNoOfColumn.size()); for (int i = 1; i <
		 * tableElementsInRow.size(); i++) {
		 * 
		 * for (int j = 1; j <= totalNoOfColumn.size(); j++) {
		 * 
		 * WebElement tableContent = driver.findElement(By.xpath(beforePath + i +
		 * afterPath + j + "]"));
		 * 
		 * if (tableContent.getText().equals("Jet Airways")) { tableContent.click(); }
		 * 
		 * }
		 * 
		 * }
		 */

	}

	@AfterMethod
	void tearDown() throws InterruptedException {

		//driver.quit();
	}

}
