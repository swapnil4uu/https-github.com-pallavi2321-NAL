package Orange;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

		public void readtestdata() throws IOException {
				
		/*		FileInputStream fi = new FileInputStream("F:\\seedinfo.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet("personalinfo");
				
				XSSFCell var = sheet.getRow(1).getCell(0);
				System.out.println(sheet.getRow(0).getCell(0));
				System.out.println("Data:" +var); */
				 
		
		FileInputStream fis = new FileInputStream("F:\\seedinfo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0); 
		String data00 = sheet1.getRow(0).getCell(0).getStringCellValue();
		String data01 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from sheet:" +data00);
		System.out.println("Data from sheet:" +data01);
		
		}
		

		public static void main(String[] args) throws IOException {
			ReadExcelData obj = new ReadExcelData();
			obj.readtestdata();
		//	obj.readtestdatadynamic();
			}

		}
