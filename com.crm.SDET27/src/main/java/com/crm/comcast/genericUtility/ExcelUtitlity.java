package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author SanjayBabu
 *
 */
public class ExcelUtitlity {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/tiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet s = wb.getSheet(sheetName);
	Row row = s.getRow(rowNum);
	String data = row.getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
}
}
