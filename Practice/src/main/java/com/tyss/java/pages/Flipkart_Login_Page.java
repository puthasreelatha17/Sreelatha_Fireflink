package com.tyss.java.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Flipkart_Login_Page {

	public WebDriver driver;
	public long ETO;
	public WebDriverWait wait;
	Actions act;

	public Flipkart_Login_Page(WebDriver driver, long ETO) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.ETO = ETO;
		this.act=new Actions(driver);
	}

	@FindBy(xpath = "//img[@alt='Flipkart']")
	private WebElement imgFlipkart;

	@FindBy(xpath = "//button[text()='✕']")
	private WebElement icnClose;

	public void clkCloseicn() {
		try {
			if (icnClose.isDisplayed()) {
				icnClose.click();
				System.out.println("Clicked on Close icon");
			}
		} catch (Exception e) {
			Assert.fail("Unable to click on Close icon");
		}
	}

	public void validateLoginPage() {
		try {
			if (imgFlipkart.isDisplayed()) {
				System.out.println("Flipkart page is displayed");
			}
		} catch (Exception e) {
			Assert.fail("Flipkart page is not displayed");
		}
	}

	public void waitForElement() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
			System.out.println("Waited till visibility of the element");
		} catch (Exception e) {
			Assert.fail("Unable to wait for the visibility of an element");
		}
	}

}
