package com.qa.opencart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
private static final String Test_Data_Sheet=System.getProperty("data");
public static Workbook book;
public static Sheet sheet;
static FileInputStream ip=null;;


public static Object[][] getTestData(String sheetname)
{ Object[][] testdata=null;
	
		if(Test_Data_Sheet==null)
		{
			
		try {
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\TestData\\behavior_preparation_grid.xlsx");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//to get file
			}
		
		else
		{
			System.out.println("testing the data"+Test_Data_Sheet);
			try {
			switch(Test_Data_Sheet.toLowerCase())
			{
			case "qa":
				ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\TestData\\EditaccountDetails.xlsx");
				break;
			case "Dev":
				ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\TestData\\EditaccountDetails.xlsx");
			}
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		try {
			book=	WorkbookFactory.create(ip);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//to get sheet
		sheet=	book.getSheet(sheetname);//to get details from registrationpage
		testdata=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
for(int i=0;i<sheet.getLastRowNum();i++)
{
	for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
	{
		testdata[i][j]=sheet.getRow(i+1).getCell(j).toString();
	}
}

	return testdata;
}

}
