package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;

import com.example.demo.responseDTOS.PhysicalGitCardReponseDto;

public class Helper {
	
	public static String[]Headers = {"transactionID","amount","status","transactionCateggory","transactionType","transactionDate","transactionMerchant"};
	public static String Sheet_Name = "TransactionList";
	
	public static ByteArrayInputStream exportDataToExcel(List<PhysicalGitCardReponseDto>list) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		try {
			
			
			
			//creating sheet within the workbook
			XSSFSheet sheet=workbook.createSheet(Sheet_Name);
			
			//creating header row
			Row row = sheet.createRow(0);
			
			//creating cells
			for(int i=0; i<Headers.length; i++)
			{
				Cell cell=row.createCell(i);
				cell.setCellValue(Headers[i]);
			}
			
			//creating rows for values
			int rowIndex = 1;
			for(PhysicalGitCardReponseDto obj : list)
			{
				Row dataRow = sheet.createRow(rowIndex++);
				dataRow.createCell(0).setCellValue(obj.getTransactionID());
				dataRow.createCell(1).setCellValue(obj.getAmount());
				dataRow.createCell(2).setCellValue(obj.getStatus());
				dataRow.createCell(3).setCellValue(obj.getTransactionCategory());
				dataRow.createCell(4).setCellValue(obj.getTransactionType());
				dataRow.createCell(5).setCellValue(obj.getTransactionDate());
				dataRow.createCell(6).setCellValue(obj.getTransactionMerchant());
				
			}
			
			//data is kept in ByteArrayOutputStream
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		 
		}
		finally
		{
			workbook.close();
			outputStream.close();
		}
	}

}
