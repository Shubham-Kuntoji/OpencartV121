package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	//DataProvider
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Exceldata.xlsx";//taking xl file from tedtData
		
		ExcelUtilities xlutil=new ExcelUtilities(path);//creating an object for XLUtitlity
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String loginData[][]=new String [totalrows][totalcols];//created for two dimension array which can
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++)  //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1",i,j);  //1,0
				
			}
		}
		return loginData;//returning two dimension array
	}

}
