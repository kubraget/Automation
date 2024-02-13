package dataDriven.exceldataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Execl {
	@Test
	public void getExecl() throws IOException {
//Object[][] data = {{"hello","text","1"},{"bye","message","143"},{"solo","call","453"}};
// every row of excel should be sent to 1 array
		FileInputStream fis = new FileInputStream("D:\\excel\\ExcelDrivendemo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			System.out.println("outer loop started");
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				System.out.println(row.getCell(j));
			}
			System.out.println("outer loop ended");
		}
	}

}
