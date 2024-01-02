package com.tyss.basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngImplementation {
	WebDriver driver;

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

		driver.get("https://www.flipkart.com/");
		System.out.println("Launched Flipkart");
	}

	@Test
	public void name() {
		WebElement title = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		if (title.isDisplayed()) {
			System.out.println("Flipkart page is displayed");
		}	
		
		WebElement icnClose = driver.findElement(By.xpath("//button[text()='✕']"));
		
		//explicit wait upgraded to duration where as timeout is depreciated
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
			
		if (icnClose.isDisplayed()) {
			icnClose.click();
			System.out.println("Clicked on close icon");
		}
	}
		@AfterClass
		public void close() {
			driver.close();
		}
	}

