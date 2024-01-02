package com.tyss.java.baseUtil;

import java.io.FileInputStream;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.java.commonutils.FileOperation;
import com.tyss.java.reports.Extent;
import com.tyss.java.reports.ExtentManager;
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
	public static final String VALIDATION_CONSTANT = "./src/main/resources/TestData/Validation_Constants.properties";
	public static WebActionUtil webActionUtil;
	public static String currentDateAndTime;
	public static String currentDateAndTimeNewFormat;
	public static Logger logger ;
	public static String className;
	public static final String driverPath ="./drivers";
	
	
	static {
		try {
			prop = new Properties();
			prop_constants = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);
			FileInputStream fis1 = new FileInputStream(VALIDATION_CONSTANT);
			prop_constants.load(fis1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {
			logger.info("Folder creation for Extent");
			FileOperation fileOperation=new FileOperation();
			fileOperation.createFiles();
		} catch (Exception e) {
			logger.error("Exception while report inititation");
		}
	}
	
//	@BeforeSuite
//	public void extentSetUp() throws IOException {
//		// Start Reporter
//		htmlReporter = new ExtentHtmlReporter("./reports/TestNG_ExtentReport.html");
//
//		// Create extent report and attach reports
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		ExtentTest test1 = extent.createTest("Pepper Fry", "Test description");
//		test1.log(Status.INFO, "This step shows usage of log(status, details)");
//		test1.info("This step shows usage of info(details)");
//
//		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/screen.png").build());
//
//		test1.addScreenCaptureFromPath("./screenshots/screen.png");
//	}

	@Parameters({ "browserName" })
	@BeforeTest(alwaysRun = true)
	public synchronized void downloadDriverExecutables(String browserName) {
		CreateDriver.setDriverExecutables(browserName);
	}
	
	@Parameters({ "browserName" })
	@BeforeClass
	public synchronized void launchBrowser(String browserName) {
		className=getClass().getSimpleName();
		logger = LoggerFactory.getLogger(getClass().getName());
		ExtentTest parentExtentTest = Extent.createTest(getClass().getSimpleName());
		ExtentManager.setParentReport(parentExtentTest);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ETO));
		webActionUtil=new WebActionUtil();
		driver.manage().window().maximize();
		
		WebDriverManager.chromedriver().setup();
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
