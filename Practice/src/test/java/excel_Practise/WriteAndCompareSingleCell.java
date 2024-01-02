package excel_Practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteAndCompareSingleCell {
public static void main(String[] args) throws Exception, IOException {
	File src = new File("C:\\Users\\Putha Sreelatha\\Downloads\\ExcelFormulas.xlsx");
	FileInputStream fis = new FileInputStream(src);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Automation");
	
	//fetch the cell values
	Cell firstCell = sheet.getRow(1).getCell(0);
	Cell secondCell = sheet.getRow(1).getCell(1); 
	
	//converting to double values
	double firstString = firstCell.getNumericCellValue();
	double secondString = secondCell.getNumericCellValue();
	
	//addition operation
	double result = firstString+secondString;
	System.out.println(result); 
	
	//Write data to the given cell
	Row row= sheet.getRow(1);
	Cell cellIndex = row.createCell(2);
	cellIndex.setCellValue(result);
	FileOutputStream fos = new FileOutputStream(src);
	wb.write(fos);

	//comparing two sheet values
	Sheet sheet1 = wb.getSheet("Manual");
	double firstSheetCellValue = sheet1.getRow(1).getCell(2).getNumericCellValue();
	double secondSheetCellValue = sheet.getRow(1).getCell(2).getNumericCellValue();
	if(firstSheetCellValue==secondSheetCellValue)
	{
		System.out.println("Two cell values: "+firstSheetCellValue+" and"+secondSheetCellValue+" are equal");
	}else {
		System.out.println("Two cell values are different");
	}
}
}
