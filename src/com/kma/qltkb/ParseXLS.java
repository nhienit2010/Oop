package com.kma.qltkb;

import java.util.*;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  

public class ParseXLS {
	public FileInputStream fis;
	public HSSFWorkbook wb;
	public HSSFSheet sheet;
	public FormulaEvaluator formulaEvaluator;
	
	public ParseXLS() throws IOException {
		this.fis=new FileInputStream(new File("D:\\HK5\\OOP\\tkb\\tkb.xls"));  // open xls file
		this.wb=new HSSFWorkbook(fis);   // create workbook
		this.sheet=wb.getSheetAt(0);  // Read index of sheet 
		this.formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator(); 
	}
	
	public String findSubjects(String day) {
		String[] result = new String[30];
		int index = 0;
		
		for (int i=0; i<6; ++i) {
			for (int j=0; j<sheet.getRow(i*13).getLastCellNum(); ++j) {
				if (sheet.getRow(i*13).getCell(j).toString().equals(day) ) {
					for (int z=1; z<=12; ++z) {
						String data = sheet.getRow(i*13+z).getCell(j).toString();
						if (data.strip().length() != 0)
							result[index++] = data;
					}
				} 
			}
		}
		return Arrays.toString(result).replaceAll("null, ","").replaceAll(", null","");
	}
}
