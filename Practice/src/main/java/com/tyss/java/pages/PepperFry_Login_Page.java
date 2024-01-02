package com.tyss.java.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PepperFry_Login_Page {

	public WebDriver driver;
	public long ETO;
	public WebDriverWait wait;
	Actions act;

	public PepperFry_Login_Page(WebDriver driver, long ETO) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.ETO = ETO;
		this.act=new Actions(driver);
	}

	/* Furniture */
	@FindBy(xpath = "//a[@name='Furniture']")
	private WebElement txtFurniture;
	
	/* Lamps and Lighting */
	@FindBy(xpath = "//a[@name='Lamps & Lighting']")
	private WebElement txtLampsLighting;
	
	/* Lamps */
	@FindBy(xpath = "//ul[@class='hd-menu-main-category-list hvr-pg-pt-sec hvr-pt-list ng-star-inserted']")
	private List<WebElement> txtLamps;
	
	/* Chairs text */
	@FindBy(xpath = "//div[@class='hd-menu-dropdown-container headerHover__wrap']/div/ul/li/a[normalize-space(text())='Beds']/parent::li/following-sibling::li")
	private List<WebElement> txtChairs;
	
	/* Furniture text */
	@FindBys({ @FindBy(xpath = "//div[@class='hd-menu-dropdown-container headerHover__wrap']/div/ul/li/a") })
	private List<WebElement> txtFurnitureDD;
	
	/* Closing frame */
	@FindBy(id = "webklipper-publisher-widget-container-notification-close-div")
	private WebElement closeFrame;
	
	/* Switch to frame */
	@FindBy(id = "webklipper-publisher-widget-container-notification-frame")
	private WebElement frame;
	
	
	public void waitForElement() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
			System.out.println("Waited till visibility of the element");
		} catch (Exception e) {
			Assert.fail("Unable to wait for the visibility of an element");
		}
	}


	
	public void CloseFrame() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.switchTo().frame(frame);
			closeFrame.click();
			
		} catch (Exception e) {
			Assert.fail("Unable to close frame");
		}
	}
	
	public void mouseHoverFurniture() {
		try {
			Thread.sleep(1000);
			act.moveToElement(txtFurniture).perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail("Unable to perform mouse action");
		}
	}
	
	public void getTextChairs() {
		try {
			for (WebElement headers : txtChairs) {
				String headersText = headers.getText();
				System.out.println(headersText);	
		}
		} catch (Exception e) {
			Assert.fail("Unable to fetch the text");
		}
	}
	
	public void getTextFurniture() {
		try {
			for (WebElement headers : txtFurnitureDD) {
				String headersText = headers.getText();
				System.out.println(headersText);	
		}
		} catch (Exception e) {
			Assert.fail("Unable to fetch the text");
		}
	}
	
	public void getTextLamps() {
		try {
			for (WebElement headers : txtLamps) {
				String headersText = headers.getText();
				System.out.println(headersText);	
		}
		} catch (Exception e) {
			Assert.fail("Unable to fetch the text");
		}
	}
	
	public void mouseHoverLamps() {
		try {
			Thread.sleep(1000);
			act.moveToElement(txtLampsLighting).perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail("Unable to perform mouse action");
		}
	}
}
