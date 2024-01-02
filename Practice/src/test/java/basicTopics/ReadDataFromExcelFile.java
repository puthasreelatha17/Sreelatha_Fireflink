package basicTopics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Exception {

		FileInputStream fis= new FileInputStream("./src/main/resources/TestData/DemowebShop.xlsx");
		
		org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Login");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		System.out.println(data);
	}

}
