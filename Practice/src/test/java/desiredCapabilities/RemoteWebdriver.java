package desiredCapabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebdriver {

	public static void main(String[] args) throws InterruptedException {
		RemoteWebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@value='Google Search']"));
		if(logo.isDisplayed()) {
			System.out.println("Google Welcome page is displayed");
		}
		driver.close();
	}
}
