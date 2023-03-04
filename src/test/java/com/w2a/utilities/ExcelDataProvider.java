package com.w2a.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider {

	
	@DataProvider(name="test1Data")
	public Object[][] getData() throws IOException {
		String excelPath = (System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Testdata.xlsx");
		String sheet = "AddCustomerTest";

		Object[][] data = testData(excelPath, sheet);
		return data;

	}

	public Object[][] testData(String excelPath, String sheet) throws IOException {
		ExcelUtils excel = new ExcelUtils(excelPath, sheet);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object[][] data = new Object[rowCount - 1][colCount];

		// get all data as String from sheet
		for (int i = 1; i < rowCount; i++) {

			for (int m = 0; m < colCount; m++) {

				String cellData = excel.getCellDataString(i, m);
				data[i - 1][m] = cellData;

			}
			System.out.println();
		}
		excel.workbook.close();
		return data;
		
	}
	
	
	
}
