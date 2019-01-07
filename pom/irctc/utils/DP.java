package pom.irctc.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DP {
	public static String[][] getData(String dataSheetName) throws IOException{
		String[][] testData;
		//FileInputStream fis=new FileInputStream("./testData/"+dataSheetName+".xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("./testData/"+dataSheetName+".xlsx"));
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=1;
		int columnCount=sheet.getRow(0).getLastCellNum();
		testData=new String[rowCount][columnCount];
		XSSFRow row=sheet.getRow(1);
		for(int j=0;j<columnCount;j++)
			testData[0][j]=row.getCell(j).getStringCellValue();
		return testData;
	}

}
