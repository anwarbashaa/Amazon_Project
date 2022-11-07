package com.Project.PROJECT_NAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXSWrite {
	
	private static void excelsheetwrite() throws IOException {

		File file=new File("C:\\Abdul\\datadriven_WF.xlsx");
		
		FileInputStream fileinput=new FileInputStream(file);
		
		Workbook workbook= new XSSFWorkbook(fileinput);
		
		Sheet createSheet = workbook.createSheet("CreateFile");
		
		Row createRow = createSheet.createRow(0);
		
		Cell createCell = createRow.createCell(2);
		
		createCell.setCellValue("one");
		
		workbook.getSheet("CreateFile").createRow(2).createCell(4).setCellValue("four");
		
		FileOutputStream Fileoutput=new FileOutputStream(file);
		
		workbook.write(Fileoutput);
		
		workbook.close();
		
	}

	public static void main(String[] args) throws IOException {
		
		excelsheetwrite();
		
		System.out.println("Done");

	}

}
