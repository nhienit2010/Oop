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
		// Mở file excel từ local và đọc sheet đầu tiên
		this.fis=new FileInputStream(new File("D:\\HK5\\OOP\\tkb\\tkb.xls"));  // mở file excel
		this.wb=new HSSFWorkbook(fis);   // tạo workbook
		this.sheet=wb.getSheetAt(0);  // đọc sheet thứ mà mình muốn (ở đây là sheet 0)
		this.formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator(); 
	}
	
	// Phân tích file excel và tìm ra môn học cho từng ngày ứng với input
	public String findSubjects(String day) {
		String[] result = new String[30];
		int index = 0;
		
		// Lặp qua 5 ngày từ thứ 2 đến thứ 7
		for (int i=0; i<6; ++i) {
			// Lặp qua các cột để tìm ngày trùng với input đã nhập
			for (int j=0; j<sheet.getRow(i*13).getLastCellNum(); ++j) {
				// Nếu tìm thấy ngày cần tìm thì làm công việc sau
				if (sheet.getRow(i*13).getCell(j).toString().equals(day) ) {
					// Duyệt qua 12 ô từ trên xuống ứng với 6 tiết sáng và 6 tiết chiều
					for (int z=1; z<=12; ++z) {
						// Lấy giá trị của từng ô excel
						String data = sheet.getRow(i*13+z).getCell(j).toString();
						// Nếu có tên môn học trong ô thì đưa vào mảng, không có thì bỏ qua
						if (data.strip().length() != 0)
							result[index++] = data;
					}
				} 
			}
		}

		// Nối mảng result thành một chuỗi rồi trả về
		return Arrays.toString(result).replaceAll("null, ","").replaceAll(", null","");
	}
}
