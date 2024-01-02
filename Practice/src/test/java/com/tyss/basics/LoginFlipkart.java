package com.tyss.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tyss.java.baseUtil.BaseTest;

public class LoginFlipkart extends BaseTest {
	@Test
	public void name() {
		WebElement title = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		if (title.isDisplayed()) {
			System.out.println("Flipkart page is displayed");
		}

		WebElement icnClose = driver.findElement(By.xpath("//button[text()='✕']"));

		// explicit wait upgraded to duration where as timeout is depreciated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));

		if (icnClose.isDisplayed()) {
			icnClose.click();
			System.out.println("Clicked on close icon");
		}
	}
}
