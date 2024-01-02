package desiredCapabilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome {
	public static void main(String[] args) {
		
		
		WebDriverManager.firefoxdriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		options.addArguments("--use-fake-ui-for-media-stream");
		
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");
	
	
	
	  
	 

	
}
}