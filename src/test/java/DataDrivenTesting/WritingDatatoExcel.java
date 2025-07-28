package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDatatoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("");
		Row row = sh.getRow(0);
		Cell cel = row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("Testing");

		FileOutputStream fos=new FileOutputStream("");
		wb.write(fos);
		wb.close();
		
		
		
	}

}
