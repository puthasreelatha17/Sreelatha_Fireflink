package com.tyss.java.preconditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.java.baseUtil.InitializePages;
import com.tyss.java.util.WebActionUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	public static WebDriver driver;
	public static InitializePages pages;
	long ETO;
	public static Properties prop;
	public static Properties prop_constants;
	public static final String CONFIGPATH = "./src/main/resources/TestData/config.properties";
	public static final String VALIDATION_CONSTATNT = "./src/main/resources/TestData/Validation_Constants.properties";
	public static WebActionUtil webActionUtil;
	public static String currentDateAndTime;
	public static String currentDateAndTimeNewFormat;
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	
	static {
		try {
			prop = new Properties();
			prop_constants = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);
			FileInputStream fis1 = new FileInputStream(VALIDATION_CONSTATNT);
			prop_constants.load(fis1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void extentSetUp() throws IOException {
		// Start Reporter
		htmlReporter = new ExtentHtmlReporter("./reports/TestNG_ExtentReport.html");

		// Create extent report and attach reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Pepper Fry", "Test description");
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");

		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/screen.png").build());

		test1.addScreenCaptureFromPath("./screenshots/screen.png");
	}

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();// it will download the driver
		driver = new ChromeDriver();

	}

	@BeforeMethod
	public void preConditions() {
		driver.manage().window().maximize();

		// implicit wait upgraded to duration where as timeout is depreciated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.pepperfry.com/");
		// driver.get("https://www.flipkart.com/");
		// System.out.println("Launched Flipkart");
		pages = new InitializePages(driver, ETO);
	}

	@AfterClass
	public void close() {
		driver.close();
	}

	@AfterSuite
	public void tearDownExtent() {
		extent.flush();
	}
}
