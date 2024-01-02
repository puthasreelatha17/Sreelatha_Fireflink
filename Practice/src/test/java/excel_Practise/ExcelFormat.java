package excel_Practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFormat {

	public static void main(String[] args) throws Exception {
		File src = new File("C:\\Users\\Putha Sreelatha\\Downloads\\ExcelFormulas.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Practise2");
		
		int j = 0;
		int k = 2;
		double firstCell = 0;
		double secondCell = 0;
		double result;
		for (int i = 1; i <= 4; i++) {
			firstCell = sheet.getRow(i).getCell(j).getNumericCellValue();
			secondCell = sheet.getRow(i).getCell(j + 1).getNumericCellValue();
			// addition operation
			result = firstCell + secondCell;
			
			// Write data to the given cell
						Row row = sheet.getRow(i);
						Cell cellIndex = row.createCell(k);
						cellIndex.setCellValue(result);
						FileOutputStream fos = new FileOutputStream(src);
						wb.write(fos);
		}
		//comparing two sheet values
		Sheet sheet1 = wb.getSheet("Practise1");
		String CellValue1 = null;
		String CellValue2 = null;
		
		for (int l = 1; l <=4; l++) {
			 CellValue1 = sheet1.getRow(l).getCell(k).toString();
			 CellValue2 = sheet.getRow(l).getCell(k).toString();
			 
			 if (CellValue1.equals(CellValue2)) {
					System.out.println("Both values :"+CellValue1+"and "+CellValue2+" are same");
				}else {
					System.out.println("Both values :"+CellValue1+"and "+CellValue2+" are different");
				}	
			
	} 
		 
	}

}
