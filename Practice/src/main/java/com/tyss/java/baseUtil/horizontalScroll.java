package com.tyss.java.baseUtil;

	
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class horizontalScroll {
		
		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			//WebDriverWait wait=new WebDriverWait(driver, 15);
			driver.get("https://www.redbus.in/");
			WebElement ele=driver.findElement(By.xpath("//div[@class='OfferCard__OfferCardContainer-sc-1f27jzb-0 cWNkhC']"));
	        org.openqa.selenium.Point p=ele.getLocation();
	        System.out.println(p);
			
			 
	        
		}

	}


