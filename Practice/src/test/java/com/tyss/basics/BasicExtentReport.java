package com.tyss.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicExtentReport {
	public static WebDriver driver;

	public static void main(String[] args) {
		// Start Reporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

		// Create extent report and attach reports
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		/* Test1 */
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Google search", "Sample description");

		WebDriverManager.chromedriver().setup();// it will download the driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test.log(Status.INFO, "Testcase one Started");
		driver.get("https://www.google.com/");
		test.pass("Navigated to google");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		test.pass("Data entered ibto textarea");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@value='Google Search']")).click();
		test.pass("Clicked on Google Search");
		driver.close();
		test.pass("Closed the browser");
		test.info("Testcase one completed");

		/* Test2 */
		ExtentTest test2 = extent.createTest("Google search", "Sample description");

		WebDriverManager.chromedriver().setup();// it will download the driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test2.log(Status.INFO, "Testcase two Started");
		driver.get("https://www.google.com/");
		test2.pass("Navigated to google");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		test2.pass("Data entered ibto textarea");
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@value='Google Search']")).click();
		test2.fail("Clicked on Google Search");
		driver.close();
		test2.pass("Closed the browser");
		test2.info("Testcase two completed");

		extent.flush();
	}

}
