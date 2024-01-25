package com.example.demo;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.Constants.Constant;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.responseDTOS.Response;
import com.example.demo.services.TransactionService;

@SpringBootTest
public class TransactionServiceTests {

	@InjectMocks
	public TransactionService transactionService;
	
	@Mock
	public TransactionRepository transactionRepository;
	
	@Test
	public void fetchTransaction() throws IOException
	{
		Mockito.when(transactionRepository.findByTransactionType(Mockito.any())).thenReturn(null);
		
		ResponseEntity<?> responseEntity=transactionService.fetchTransactionList(false);
		Response res = (Response) responseEntity.getBody();
		assertEquals(Constant.SUCCESS_API_CODE,res.getStatus());
		
	}
}
