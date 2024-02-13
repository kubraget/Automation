import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDriven {
	@Test
	public void getExecl() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\ExeclDemoDriven2.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet sheet = w.getSheetAt(1);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount =row.getLastCellNum();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			System.out.println("outer loop started");
			row = sheet.getRow(i+1);
			for(int j=0;j<colCount;j++)
			{
				System.out.println(row.getCell(j));
			}
			System.out.println("outer loop ended");
		}
	}

}
