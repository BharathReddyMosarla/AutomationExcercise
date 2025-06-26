package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBase 
{
	public static File f;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static  int TotalRows(String filename,String sheetname) throws Exception
	{
		f = new File(filename);
		fis = new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		int totalrows = sheet.getLastRowNum();
		return totalrows;	
	}
	public static int TotalCells(String filename,String sheetname,int rownum) throws Exception
	{
		f = new File(filename);
		fis = new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int totalcells = row.getLastCellNum();
		return totalcells;	
	}
	
	public static String getCellData(String filename,String sheetname,int rownum, int cellnum) throws Exception
	{
		f = new File(filename);
		fis = new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		String celldata=null;

		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			 celldata=cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			double value  =cell.getNumericCellValue();
			 celldata = String.valueOf(value);
		}
		return celldata;
	}
	
	public static Object[][] getData(String filename,String sheetname) throws Exception
	{
		f = new File(filename);
		fis = new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		
		int totalrows = TotalRows(filename,sheetname);
		int totalcells= TotalCells(filename,sheetname,1);
		
		Object[][] data =new Object[totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				data[i-1][j]=getCellData(filename,sheetname,i,j);
			}
		}		
		return data;
	}
}