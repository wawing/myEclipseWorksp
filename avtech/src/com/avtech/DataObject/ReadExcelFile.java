package com.avtech.DataObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	 public String[][] arrayExcelData = new String [6][12];
	 public int rowIndex=0;
	 public int columnIndex = 0;
	
	public String[][] readExcel() throws IOException {

		
		FileInputStream file = new FileInputStream(new File("C:\\ww.workspace\\avtech\\resources\\usersInfo.xlsx"));
        
		//Get the workbook instance for XLS file 
		XSSFWorkbook workbook = new XSSFWorkbook (file);
		 
		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		 
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		
		 while (rowIterator.hasNext()) {
		        Row nextRow = rowIterator.next();
		        Iterator<Cell> cellIterator = nextRow.cellIterator();
		        rowIndex = nextRow.getRowNum();
		 
		        while (cellIterator.hasNext()) {
		            Cell nextCell = cellIterator.next();
		            columnIndex = nextCell.getColumnIndex();
		 
		            switch (columnIndex) {
			            case 1:
			            	System.out.print(getCellValue(nextCell));
			                break;
			            case 2:
			            	System.out.print (getCellValue(nextCell));
			                break;
			            default:
			            	System.out.print (getCellValue(nextCell));
			                break;
			        } //end switch
		            String str = getCellValue(nextCell).toString();
		            //System.out.println(str);
		            	arrayExcelData[rowIndex][columnIndex] = str;
		            System.out.print(", ");
		 
		        }
		        System.out.println("");
			}
		
		 
		 workbook.close();
		 file.close();
		 return arrayExcelData;

} //ends readExcel()

	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
}