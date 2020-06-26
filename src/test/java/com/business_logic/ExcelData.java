package com.business_logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelData {
	
	
	public File file = null;
	//Method to Extract Data from Excel Sheet
	public Sheet SheetData() throws BiffException, IOException , NullPointerException{
		
		file = new File(System.getProperty("user.dir") + "/resources/TestData.xlsx");
		String FilePath = "C:\\Users\\MayurDugad\\Desktop\\Automation_Project\\Amazon_Assignment\\resources\\TestData.xlsx";// excel path
		FileInputStream fileInputStream = new FileInputStream(FilePath);
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(0);
			
		return sheet;
	}
	

	public String Username() throws BiffException, IOException , NullPointerException{

		String username = SheetData().getCell(0,1).getContents();	
		return username;
	}
	
	
	public String Password() throws BiffException, IOException , NullPointerException{
 
		String password =  SheetData().getCell(1,1).getContents();					
		return password;
	}
	
	public String SearchItem() throws BiffException, IOException , NullPointerException{
		 
		String searchItem =  SheetData().getCell(1,2).getContents();					
		return searchItem;
	}
	
		
	
}
