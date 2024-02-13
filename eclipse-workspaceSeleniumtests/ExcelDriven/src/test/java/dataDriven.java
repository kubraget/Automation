 import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	public ArrayList<String> getData(String TestcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\excel\\ExcelDrivendemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> Tcell = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (Tcell.hasNext()) {
					Cell value = Tcell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {

						Iterator<Cell> Pcell = r.cellIterator();
						while (Pcell.hasNext()) {
							Cell c = Pcell.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							}
					}
					
				}
			}
		}
		return a;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//5)after u grab purchase testcase row = pull all the data of that row and feed into test 
		ArrayList<Object> a = new ArrayList<Object>();
		// 1)create object for XSSFWorkbook class -> get hold of excel
		FileInputStream fis = new FileInputStream("D:\\excel\\ExcelDrivendemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);// Acess to Excel is given by fis
		// 2) get Access to sheet
		int sheets = workbook.getNumberOfSheets();
// get the no of sheets. so that we can iterate through that each and every sheet to get the desired sheet(testdata)
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
//(1*)Identify Testcases column by sanning the entire 1st row
// iterator = to iterate each and every row of the sheet
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				// 3) get Access to all rows of sheet
				Row firstrow = rows.next();
				Iterator<Cell> Tcell = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int column = 0;
				while (Tcell.hasNext()) {
					Cell value = Tcell.next();// Tcell = TestCases cell
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;// desired column (column = 0)
					}
					k++;
				}
				System.out.println(column);
//(2*)Once column is identified the scan entire testcase column to identify purchase testcase row
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
//(3*)after u grab purchase testcase row = pull all the data of that row and feed into test
						Iterator<Cell> Pcell = r.cellIterator();
						while (Pcell.hasNext()) {
							System.out.println(Pcell.next().getStringCellValue());
						}
					}
				}
			}
		}
	}
}
