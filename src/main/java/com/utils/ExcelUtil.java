package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.FrameworkConstants;

public final class ExcelUtil {

	private ExcelUtil() {}
	
	public static List<Map<String, String>> getData(String sheetname) {
		List<Map<String, String>> list = null;
		XSSFWorkbook workbook = null;
		
		try(FileInputStream input = new FileInputStream(FrameworkConstants.getExcelTestdataPath())) {
			workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			Map<String, String> map = null;
			list = new ArrayList<>();
			
			int lastRowNum = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			
			DataFormatter formatter = new DataFormatter();
			
			for(int rowNum = 1; rowNum<= lastRowNum; rowNum++) {
				map = new HashMap<>();
				for(int colNum = 0; colNum<lastColNum; colNum++) {
					String key = sheet.getRow(0).getCell(colNum).getStringCellValue();
					//String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
					String value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
