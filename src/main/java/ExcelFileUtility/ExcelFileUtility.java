package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{
	public String getDataFromExcel(String sheetname,int rownum,int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/TestScriptDataAdv (1).xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rownum).getCell(CellNum).getStringCellValue();
		wb.close();
		return data;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getting Data From Multiple row
	public int togetRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("/Testdat/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}

}
