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

public class DataDrivenTestingPractise {
	static WebDriver driver;
	static Cell cellData ;
	
	public static void filePath(String fileName, String sheetName, int rowNumber, int CellNumber) throws EncryptedDocumentException, IOException {
		File src = new File(fileName);
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		 cellData = sheet.getRow(rowNumber).getCell(CellNumber);
	}
	
	public static void browserSetUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public static void login() {
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys(cellData.getStringCellValue());
		driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
		WebElement err = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
	    System.out.println(err.getText());
	}
	
	public static void close() {
		driver.close();
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	browserSetUp();
	filePath("C:\\Users\\Putha Sreelatha\\Downloads\\DemowebShop.xlsx", "Login", 1, 0);
//	filePath("./src/main/resources/TestData/DemowebShop.xlsx", "Login", 1, 0);
	login();
	close();
	
	}

}
