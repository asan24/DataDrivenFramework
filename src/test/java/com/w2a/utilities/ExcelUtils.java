package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount()   {

		int rowCount = sheet.getPhysicalNumberOfRows();
		
		return rowCount;

	}

	public static int getColCount()   {

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		return colCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {

		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell == null) {
			return "";
		} else {
			CellType cellType = sheet.getRow(rowNum).getCell(colNum).getCellType();

			switch (cellType) {
			case STRING:
				String cellData = cell.getStringCellValue();
				if (cellData != null)
					return cellData;
			default:
				int cellData1 = (int) cell.getNumericCellValue();
				return String.valueOf(cellData1);
			}
		}
		
	}

	public static double getCellDataNumber(int rowNum, int colNum) {

		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell == null) {
			return 0.0;
		} else {
			CellType cellType = sheet.getRow(rowNum).getCell(colNum).getCellType();
			if (cellType == cellType.NUMERIC) {
				double cellData = cell.getNumericCellValue();
				return cellData;
			} else {
				return 0.0;
			}

		}
		
	}
	
	
	
}
