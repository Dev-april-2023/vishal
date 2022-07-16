package practice.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Exceldata {

	
	public void readExceldata() throws Exception {
		
		String value1 = "EmployeeName";
		String value2 = "Salary";
	
		//FileInputStream fis = new FileInputStream();
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet1 = wb.createSheet("TestData");
		XSSFRow row = sheet1.createRow(0);
		XSSFCell cell1 = row.createCell(0);
		cell1.setCellValue(value1);
		XSSFCell cell2 = row.createCell(1);
		cell2.setCellValue(value2);
		
		String excel = ".\\datafiles\\employeedata.xlsx";
	    FileOutputStream fos = new FileOutputStream(excel);
	    wb.write(fos);
	    fos.close();
	
	}
	public void exceldataReader() throws Exception {
		
		String filepath = ".\\datafiles\\employeTestdata.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("TestData");
		
		int rows = sheet1.getLastRowNum();
		int cols = sheet1.getRow(0).getLastCellNum();
		
		for(int i=0; i<rows;i++) 
		{
			XSSFRow row = sheet1.getRow(i);
		
			for(int j=0; j<cols;j++) 
			{
				XSSFCell cell = row.getCell(j);
				switch(cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue()); break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue()); break;
					 
				}
				
				System.out.print("  |  ");
			}
			
			System.out.println();
			
		}
		wb.close();
	
	}
	public Object[][] senExceldataTo_dataProvider() throws IOException {
		
		String filepath=".\\datafiles\\employeTestdata.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Object data[][] = null;
		
		int rows = sheet1.getLastRowNum();
		int cols = sheet1.getRow(0).getLastCellNum();
		
	    data = new Object[rows][cols];
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet1.getRow(i+1);
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				switch(cell.getCellType()) {
				case STRING:
				data[i][j]=cell.getStringCellValue(); break;
				case NUMERIC:
			    data[i][j]=cell.getNumericCellValue(); break;
				default:
					break;
			    
				}
				
			}
		}
	    wb.close();

        for(int i=0;i<rows;i++) {
        	for(int j=0;j<cols;j++) {
        		System.out.print(data[i][j]);
        		System.out.print("  |   ");
        	}
        	System.out.println(" ");
        }
		return data;
		
		
		
		
	}



public static void main(String[] args) throws Exception {
	
	 Exceldata exl = new Exceldata();
	 exl.senExceldataTo_dataProvider();
	 
	}
}
