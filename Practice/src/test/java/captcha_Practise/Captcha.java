package captcha_Practise;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Captcha {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		try {
			driver.get("https://www.spglobal.com/ratings/en/register");
			WebElement element = driver.findElement(By.xpath("//input[@name='ctl00$Body$cntrRegistration1$lastname']"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			element.isDisplayed();
			
			Thread.sleep(3000);
			WebElement ele=driver.findElement(By.xpath("//img[@id='captchaImage']"));
			File src = ele.getScreenshotAs(OutputType.FILE);
			String path="C:\\Users\\Putha Sreelatha\\SreelathaPractice\\Practice\\captcha\\captcha.png";
			FileHandler.copy(src, new File(path));
		    Thread.sleep(3000);
		    BufferedImage fullImg=ImageIO.read(new File(path));
		   // BufferedImage subimg=fullImg.getSubimage(0,9,90,29);
		   // Raster data = fullImg.getData();
		   // String b=fullImg.toString();
		    ImageIO.write(fullImg, "png", new File("./Screenshots/screenshot.png"));
			File file=new File("./Screenshots/screenshot.png");
			ITesseract image= new Tesseract();
			image.setDatapath("C:\\Users\\Putha Sreelatha\\Desktop\\testData");
		    String str=image.doOCR(file);
	
		    System.out.println(str);
		    
		} catch (Exception e) {
			System.out.println("Exception caught at"+e.getMessage());
		}
driver.close();
	}

}
