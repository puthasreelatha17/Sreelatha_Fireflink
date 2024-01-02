package basicTopics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {

		FileInputStream fis= new FileInputStream("./src/main/resources/TestData/config.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String url = prop.getProperty("flipkart_Url");
		
		WebDriverManager.chromedriver().setup();//it will download the driver
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Flipkart launched successfully");
		driver.close();
	}

}
