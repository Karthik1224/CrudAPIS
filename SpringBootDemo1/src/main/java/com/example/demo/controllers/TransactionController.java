package com.example.demo.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.Constant;
import com.example.demo.Utilities.ExcelGenerator;
import com.example.demo.modals.PhysicalGiftCardTransaction;
import com.example.demo.responseDTOS.Response;
import com.example.demo.responseDTOS.PhysicalGitCardReponseDto;
import com.example.demo.services.TransactionService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	private static final Logger log = (Logger) LoggerFactory.getLogger(TransactionController.class);
	@Autowired
	public TransactionService transactionService;

	@GetMapping("/fetchTransactionList")
	public ResponseEntity fetchTransactionList(@RequestParam Boolean isdownloaded) {
		try {
			return transactionService.fetchTransactionList(isdownloaded);
		} catch (Exception e) {

			log.error("Exception occured in method fetchTransactionList and the value : {} ", e.getMessage());
			return new ResponseEntity("ERROR", HttpStatus.OK);
		}
	}
    
	@GetMapping("/fetchAllTransactionsList")
	public ResponseEntity fetchAllTransactions()
	{
		CompletableFuture<List<PhysicalGiftCardTransaction>>list1 =transactionService.fetchAllTransactions();
		CompletableFuture<List<PhysicalGiftCardTransaction>>list2 =transactionService.fetchAllTransactions();
		CompletableFuture<List<PhysicalGiftCardTransaction>>list3 =transactionService.fetchAllTransactions();
		CompletableFuture.allOf(list1,list2,list3).join();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
     
	

}
