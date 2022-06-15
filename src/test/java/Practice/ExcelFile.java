package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//
		FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//control the sheet
		Sheet sheet = wb.getSheet("arsh");
		//control the row
		Row row = sheet.getRow(1);
		//control the cell
		Cell cell = row.getCell(2);
		String data = cell.getStringCellValue();
		wb.close();
		System.out.println(data);
		/* Cell cell = row.createCell(5);
		cell.setCellValue("arshad");
		//open the workbook in write mode
		FileOutputStream fos = new FileOutputStream("./data/Book1.xlsx");
		wb.write(fos); */
		// wb.close();
		

	}

}
