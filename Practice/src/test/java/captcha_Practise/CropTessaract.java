package captcha_Practise;

import java.awt.image.BufferedImage;
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

public class CropTessaract {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		try {
		driver.get("https://ethicsinfotech.in/contact");
		WebElement element = driver.findElement(By.xpath("//h2[text()='We would love to hear from you!']"));
		/* Scroll to element*/
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.isDisplayed();
		WebElement ele=driver.findElement(By.xpath("(//input[@name='captcha_code'])[2]"));
		
		/* Screenshot*/
		File src = ele.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Putha Sreelatha\\SreelathaPractice\\Practice\\captcha\\captcha.png";
		FileHandler.copy(src, new File(path));
	
		/* Crop image */
		BufferedImage fullImg=ImageIO.read(new File(path));
		BufferedImage subimg=fullImg.getSubimage(0,9,90,29);
		ImageIO.write(subimg, "png", new File("./Screenshots/screenshot.png"));
		
		/* Get text from cropped image*/
		File file=new File("./Screenshots/screenshot.png");
		ITesseract image= new Tesseract();
		image.setDatapath("C:\\Users\\Putha Sreelatha\\Desktop\\testData");
	    String str=image.doOCR(file);
	    System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();

	}

}
