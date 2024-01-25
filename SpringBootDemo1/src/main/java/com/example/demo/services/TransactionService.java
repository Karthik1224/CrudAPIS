package com.example.demo.services;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.math3.analysis.function.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.controllers.TransactionController;
import com.example.demo.enums.TransactionType;
import com.example.demo.Constants.Constant;
import com.example.demo.Utilities.ExcelGenerator;
import com.example.demo.modals.PhysicalGiftCardTransaction;
import com.example.demo.responseDTOS.Response;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.responseDTOS.PhysicalGitCardReponseDto;
import com.example.demo.responseDTOS.ResponseDto;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Service
public class TransactionService {

	private static final Logger log = (Logger) LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	public TransactionRepository transactionRepository;

	public ResponseEntity<?> fetchTransactionList(Boolean isDownloaded) throws IOException {
		log.info("Downloaded value of flag :{}", isDownloaded);
		List<ResponseDto> transactionList = transactionRepository.findByTransactionType(TransactionType.DEBIT.name());
		if (isDownloaded.equals(false)) {
			return new ResponseEntity(
					new Response(Constant.SUCCESS_API_CODE, Constant.SUCCESS_API_MESSAGE, transactionList),
					HttpStatus.OK);
		} else {
			return downloadExcelFile(transactionList);
		}

	}

	private ResponseEntity downloadExcelFile(List<ResponseDto> transactionList) throws IOException {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=transactionList.xlsx";
		response.setHeader(headerKey, headerValue);

		ExcelGenerator generator = new ExcelGenerator(transactionList);
		generator.generateExcelFile(response);
		log.info("Successfully downloaded excel file");
		return new ResponseEntity("generated", HttpStatus.OK);
	}
	
	@Async
	public CompletableFuture< List<PhysicalGiftCardTransaction>>fetchAllTransactions()
	{
		log.info("fetching list of Transactions by {} ",Thread.currentThread().getName());
		List<PhysicalGiftCardTransaction>list = transactionRepository.findAll();
		return CompletableFuture.completedFuture(list);
		
	}

}
