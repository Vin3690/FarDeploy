package helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getdata(String excelLocation, String sheetName) {
		try {
			Object dataset[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create a workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheetname from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// Count number of active rows in sheet
			int totalRow = sheet.getLastRowNum();
			// Count active columns in row
			int totalcolums = sheet.getRow(0).getLastCellNum();
			dataset = new Object[totalRow+1][totalcolums];
			// Iterate through each row one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				// for every rows, we need to iterate over columns
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					switch (cell.getCellTypeEnum()) {
					case STRING:
						dataset[i-1][j-1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataset[i-1][j-1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataset[i-1][j-1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataset[i-1][j-1] = cell.getCellFormula();
						break;
					default:
						System.out.println("No matching enum type data found...!!!");
						break;
					}
				}
			}
			return dataset;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
		public void updateResult(String excelLocation,String sheetName, String testCaseName, String testStatus) {
			try{
				FileInputStream file = new FileInputStream(new File(excelLocation));
			
			// Create a workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheetname from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// Count number of active rows in sheet
			int totalRow = sheet.getLastRowNum()+1;
			for(int i=1; i<totalRow;i++) {
			XSSFRow row = sheet.getRow(i);
			String ce = row.getCell(0).getStringCellValue();
			if(ce.contains(testCaseName)) {
				row.createCell(1).setCellValue(testStatus);
				file.close();
				log.info("Result updated in sheet");
				FileOutputStream out=new FileOutputStream(new File(excelLocation));
				workbook.write(out);
				out.close();
			}
		}
	}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	public static void main(String[] args) {
		ExcelHelper excelHelper=new ExcelHelper();
		String excelLocation="D:\\Eclipse-workspace\\POM\\resources\\configfile\\TestData.xlsx";
//		Object[][] data = excelHelper.getdata(excelLocation, "Logindata");
//		System.out.println(data.toString());
		
		excelHelper.updateResult(excelLocation, "TestscriptResult", "Registration", "PASS");
		excelHelper.updateResult(excelLocation, "TestscriptResult", "Login", "PASS");
		excelHelper.updateResult(excelLocation, "TestscriptResult", "Add to cart", "FAIL");
	}
}
