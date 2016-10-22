package tools; //this package was created in selenium class 3/12/16

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//this was given in class by instructor 3/12/16
public class Readexcel1 {

		public  Object[][] readExcelData() throws IOException{
	//public static void main(String[] args) throws Exception{
	    int rows;
	    int xCols;
	    int cols;     

	    File myxl = new File("C:\\ww.workspace\\avtech\\resources\\myData.xlsx");

        FileInputStream myStream = new FileInputStream(myxl);
        XSSFWorkbook myWB = new XSSFWorkbook(myStream);
        XSSFSheet mySheet = myWB.getSheet("Sheet1");
        rows = mySheet.getLastRowNum()+1;
        cols = mySheet.getRow(0).getLastCellNum(); 
        System.out.println("Total Rows:"+rows);
        System.out.println("Total Cols:"+cols);
        
        Object[][] retkeyword=new Object[rows-1][2];
        
        List<List<String>> masterList = new ArrayList<List<String>>();
      
      for (int i = 1; i < rows; i++)    	  
        {
              XSSFRow row = mySheet.getRow(i);
              List<String> ls = new ArrayList<String>();
               for (int j = 0; j < cols; j++) 
                  {
                 XSSFCell cell =  row.getCell(j); //To read value from each col in each row
                 String value = cellToString(cell);
                  ls.add(value);
                  //System.out.println("ls is "+ ls);
                  }
               masterList.add(ls);
        }
      
      Object[][] masterArray = new Object[masterList.size()][masterList.get(0).size()];
      for(int i = 0; i < masterList.size(); i++)
      {
    	 masterArray[i] = masterList.get(i).toArray();
      }
      
      
//      for(int i = 0; i < masterArray.length; i++)
//      {
//       for(int j = 0; j < masterArray[i].length; j++)
//       {
//    	   System.out.print(masterArray[i][j]+" | ");
//       }
//       System.out.println();
//      }
      return masterArray;
	}
	
	
      public static String cellToString(XSSFCell cell) {

          //This function will convert an object of type excel cell to a string value
          int type = cell.getCellType();
          Object result;
          switch (type) {
          case XSSFCell.CELL_TYPE_NUMERIC: //0
                          result = cell.getNumericCellValue();
            break;
          case XSSFCell.CELL_TYPE_STRING: //1
                           result = cell.getStringCellValue();
            break;
          case XSSFCell.CELL_TYPE_FORMULA: //2
                          throw new RuntimeException("We can't evaluate formulas in Java");
          case XSSFCell.CELL_TYPE_BLANK: //3
                          result = "-";
                          break;
          case XSSFCell.CELL_TYPE_BOOLEAN: //4
                          result = cell.getBooleanCellValue();
                          break;
          case XSSFCell.CELL_TYPE_ERROR: //5
                          throw new RuntimeException ("This cell has an error");
          default:
                          throw new RuntimeException("We don't support this cell type: " + type);
                                                          
          }
          return result.toString();
     }                    

}
	