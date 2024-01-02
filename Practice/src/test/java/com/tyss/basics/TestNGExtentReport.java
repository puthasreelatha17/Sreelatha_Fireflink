package com.tyss.basics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGExtentReport {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		// Start Reporter
		htmlReporter = new ExtentHtmlReporter("./reports/TestNG_ExtentReport.html");

		// Create extent report and attach reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void name() {
		WebDriverManager.chromedriver().setup();// it will download the driver
		driver = new ChromeDriver();//up-casting
		driver.manage().window().maximize();//maximize window
	}

	@Test(priority=1)
	public void test() throws IOException {
		ExtentTest test = extent.createTest("Google search", "Sample description");
		System.out.println("Chrome browser launched");
		driver.get("https://www.google.com/");
		System.out.println("Launched the application");
		test.pass("Navigated to google");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshots.png").build());
		test.addScreenCaptureFromPath("./screenshots/TestNGExtent.png");
	}

	@Test(priority=2)
	public void test1() throws IOException {
		ExtentTest test1 = extent.createTest("Google search", "Test description");
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");

		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshots.png").build());

		test1.addScreenCaptureFromPath("./screenshots/TestNGExtent.png");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("Testcase completed");
	}

	@AfterSuite
	public void tearDownExtent() {
		extent.flush();
	}

}
