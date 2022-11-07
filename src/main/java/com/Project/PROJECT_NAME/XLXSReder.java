package com.Project.PROJECT_NAME;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXSReder 
{

	static String value;
	
	public  static String singleData(String name,int rowno ,int cellno) throws IOException {

		File file=new File("C:\\Abdul\\datadriven_WF.xlsx");

		FileInputStream inputstrime=new FileInputStream(file);

		Workbook workbook= new XSSFWorkbook(inputstrime);

		Sheet sheet= workbook.getSheet(name);

		Row row= sheet.getRow(rowno);

		Cell cell= row.getCell(cellno);

		CellType ce=cell.getCellType();

		if (ce.equals(CellType.STRING)) {

			value = cell.getStringCellValue();
		}
		else if(ce.equals(CellType.NUMERIC)) {
			double d = cell.getNumericCellValue();
			int i=(int) d;
			
			value = String.valueOf(i);
		}
		return value;
	}
	
	
	public static void Screenshot(String name) throws AWTException, IOException {
		Robot robot=new Robot();
		
		Dimension screenst=Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rec=new Rectangle(screenst);
		
		BufferedImage createScreenCapture = robot.createScreenCapture(rec);
		
		File fi=new File("C:\\Users\\shake\\eclipse-workspace\\datadriven\\Screenshot"+"name"+".png");
		
		ImageIO.write(createScreenCapture, "png", fi);
	}
	
	public static void main( String[] args ) throws IOException, AWTException
	{
		XLXSReder xs = new XLXSReder();
	//	xs.singleData();
		Screenshot("abdul");

	}
}
