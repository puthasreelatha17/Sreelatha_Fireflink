package com.tyss.basics;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogger {
	public static WebDriver driver;
	public static Logger log= LoggerFactory.getLogger(TestLogger.class);
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		log.info("Driver set up is completed");
		driver = new ChromeDriver();
		log.info("Chrome browser is launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Implicit wait of 10 seconds");
		driver.manage().window().maximize();
		log.info("Maximized the window");
		driver.get("https://www.myntra.com/");
		log.info("Logged into Myntra");
		try {
			boolean text= driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			log.error("Exception occured", new Exception("Element Not Found"));
		}
		finally {
			driver.quit();
			log.info("Closed the driver");
		}
	}	
}
