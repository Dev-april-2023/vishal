package practice.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArraysConcept {

	
	public void sortedArray() {
		
		int a[] = {20,10,30,15,50};
		
		int n= a.length;
		System.out.println(n);
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<n-1;j++) {
				
				if(a[j]>a[j+1]) {
					
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				
				}
			}
			
		}
		System.out.println("After Sorting: "+ Arrays.toString(a));
		
	}
	
	public void sortedArralist() {
		int a[] = {20,10,30,15,50};
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<a.length;i++) {
			list.add(a[i]);
		}
		//System.out.println(list);
		Collections.sort(list);
		int n = list.size();
		System.out.println("After Sortinng: "+list + "second lowest number"+list.get(1));
	}
	
	
	public void getExceldata(String dpt) throws IOException {

		String file = ".\\datafiles\\employeedata.xlsx";

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("TestData");
		int rows = sheet1.getLastRowNum();
		int cols = sheet1.getRow(0).getLastCellNum();

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet1.getRow(i + 1);
			String department = row.getCell(0).getStringCellValue();

			if (department.equalsIgnoreCase(dpt)) {
				XSSFCell cell = row.getCell(1);
				double data = cell.getNumericCellValue();
				list.add((int) data);

			}
		}
		Collections.sort(list);
		System.out.println("list of salary =" + list + "  " + "least salary in " + dpt + " is :" + (list.get(0)));

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArraysConcept ac= new ArraysConcept();
		
		ac.getExceldata("bpo");
		
		
	}

}
