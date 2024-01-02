package captcha_Practise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.tyss.java.baseUtil.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Tessaract extends BaseTest{
	public static void main(String[] args) throws IOException, Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		try {
			driver.get("https://ethicsinfotech.in/contact");
			WebElement element = driver.findElement(By.xpath("//h2[text()='We would love to hear from you!']"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			element.isDisplayed();
			WebElement ele=driver.findElement(By.xpath("(//input[@name='captcha_code'])[2]"));
			File src = ele.getScreenshotAs(OutputType.FILE);
			String path="C:\\Users\\Putha Sreelatha\\SreelathaPractice\\Practice\\captcha\\captcha.png";
			FileHandler.copy(src, new File(path));
		
			ITesseract image= new Tesseract();
			image.setDatapath("C:\\Users\\Putha Sreelatha\\Desktop\\testData");
		    String str=image.doOCR(new File(path));
	
		    System.out.println(str);
		    
		} catch (Exception e) {
			System.out.println("Exception caught at"+e.getMessage());
		}
	}

}
