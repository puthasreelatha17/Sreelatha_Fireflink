package com.tyss.basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfWebelement {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriverManager.chromedriver().setup();//it will download the driver
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	
	//implicit wait upgraded to duration where as timeout is depreciated
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	driver.get("https://www.flipkart.com/");
	WebElement icnClose = driver.findElement(By.xpath("//button[text()='✕']"));
	Thread.sleep(1000);
	File source = ((TakesScreenshot)icnClose).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(source, new File("./screenshots/elementCloseIcon.png"));
	Thread.sleep(3000);
	driver.close();
}
}
