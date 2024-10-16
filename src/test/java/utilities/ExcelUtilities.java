package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtilities(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException{
		fis=new FileInputStream(path);
		workbook =new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetName,int rownum, int colnum) throws IOException {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);//Return the formatted value of a call as a String regardless
		}
		catch(Exception e)
		{
			data="";
			
		}
		workbook.close();
		fis.close();
		return data;
		
		
	}
	
	public void setCellData(String sheetName, int rownum, int colnum,String data) throws IOException {
		File xlfile=new File(path);
		if(!xlfile.exists()) {
			
		fos=new FileOutputStream(path);
		workbook= new XSSFWorkbook();
		workbook.write(fos);
		}
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1) {
			workbook.createSheet(sheetName);
			sheet=workbook.getSheet(sheetName);
			
			if(sheet.getRow(rownum)==null) {
				sheet.createRow(rownum);
				row=sheet.getRow(rownum);
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				fos=new FileOutputStream(path);
				workbook.write(fos);
				workbook.close();
				fis.close();
				fos.close();
			}
			
			
		
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
