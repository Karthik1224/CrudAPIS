package com.example.demo.responseDTOS;

import java.sql.Date;

public interface ResponseDto{
   
	String getTransactionID();
	String getAmount();
	String getStatus();
	String getTransactionCategory();
	String getTransactionType();
	Date getTransactionDate();
	String getTransactionMerchant();
}
