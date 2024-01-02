package com.tyss.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetUp {

	public static void main(String[] args) throws InterruptedException {
		
		//setup is not required
		WebDriverManager.chromedriver().setup();//it will download the driver
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//implicit wait upgraded to duration where as timeout is depreciated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://trello.com/");
		System.out.println("Launched Trello");
		WebElement logo = driver.findElement(By.xpath("//a[@data-testid='logo_link']"));
		if (logo.isDisplayed()) {
		System.out.println("Trello page is displayed");
		}

		/* It will switch to new window */
	//	driver.switchTo().newWindow(WindowType.WINDOW);
		
		/* It will switch to new tab */
		WebDriver parent = driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://www.flipkart.com/");
		System.out.println("Launched Flipkart");
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

		driver.quit();
	}

}
