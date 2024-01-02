package excel_Practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File src = new File("C:\\Users\\Putha Sreelatha\\Downloads\\DemowebShop.xlsx");
		//File src = new File("./src/main/resources/TestData/DemowebShop.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Login");
		Cell firstCell = sheet.getRow(1).getCell(0);
		Cell secondCell = sheet.getRow(1).getCell(1); 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys(firstCell.getStringCellValue());
		driver.findElement(By.id("Password")).sendKeys(secondCell.getStringCellValue());
		
		driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
		WebElement err = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
	    System.out.println(err.getText());
	}
}
