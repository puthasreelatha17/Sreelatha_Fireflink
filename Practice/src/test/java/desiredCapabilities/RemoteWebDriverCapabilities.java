package desiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverCapabilities {

	public static void main(String[] args) throws MalformedURLException {

		String hub_URL = "http://localhost:4444/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		DesiredCapabilities cap = new DesiredCapabilities();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		options.addArguments("--use-fake-ui-for-media-stream");
	
		capabilities.setCapability("goog:chromeOptions", options);
		capabilities.setBrowserName("chrome");
		cap.merge(capabilities);
		URL url = new URL(hub_URL);
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement logo = driver
				.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@value='Google Search']"));
		if (logo.isDisplayed()) {
			System.out.println("Google Welcome page is displayed");
		}
		driver.close();

	}

}
