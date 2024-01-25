package com.example.demo.Utilities;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.MultiValueMap;

import com.example.demo.responseDTOS.PhysicalGitCardReponseDto;
import com.example.demo.responseDTOS.ResponseDto;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	private List<ResponseDto> transactionList;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	public static String[] Headers = { "transactionID", "amount", "status", "transactionCateggory", "transactionType",
			"transactionDate", "transactionMerchant" };
	public static String Sheet_Name = "TransactionList";

	public ExcelGenerator(List<ResponseDto> transactionList) {
		this.transactionList = transactionList;
		workbook = new XSSFWorkbook();
	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	private void writeHeader() {
		// creating sheet within the workbook
		sheet = workbook.createSheet(Sheet_Name);

		// creating header row
		Row row = sheet.createRow(0);

		// creating cells
		for (int i = 0; i < Headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Headers[i]);
		}

	}

	private void write() {
		int rowIndex = 1;
		for (ResponseDto obj : transactionList) {
			Row dataRow = sheet.createRow(rowIndex++);
			dataRow.createCell(0).setCellValue(obj.getTransactionID());
			dataRow.createCell(1).setCellValue(obj.getAmount());
			dataRow.createCell(2).setCellValue(obj.getStatus());
			dataRow.createCell(3).setCellValue(obj.getTransactionCategory());
			dataRow.createCell(4).setCellValue(obj.getTransactionType());
			dataRow.createCell(5).setCellValue(obj.getTransactionDate());
			dataRow.createCell(6).setCellValue(obj.getTransactionMerchant());

		}

	}

}
