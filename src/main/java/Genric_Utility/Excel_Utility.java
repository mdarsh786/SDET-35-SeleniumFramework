package Genric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int CellNum) throws EncryptedDocumentException, IOException
	{
		/**
		 * @author Arshad
		 * here we are fetching the data from excel file
		 */
		//String path1 = "./data/Book2.xlsx";
		FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("arsh");
		 Row row = sheet.getRow(1);
		 Cell cell = row.getCell(3);
		 String data = cell.getStringCellValue();
		
		return data;
	}

}
