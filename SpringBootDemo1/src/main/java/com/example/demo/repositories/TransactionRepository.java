package com.example.demo.repositories;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.controllers.TransactionController;
import com.example.demo.enums.TransactionType;
import com.example.demo.modals.PhysicalGiftCardTransaction;
import com.example.demo.responseDTOS.PhysicalGitCardReponseDto;
import com.example.demo.responseDTOS.ResponseDto;

import ch.qos.logback.classic.Logger;


@Repository
public interface TransactionRepository extends JpaRepository<PhysicalGiftCardTransaction,String> {
      
	  @Query(nativeQuery = true,value="Select transactionID,amount,status,transactionCategory,transactionType,transactionDate,transactionMerchant from PhysicalGiftCardTransaction where transactionType=:transactionType")
	  List<ResponseDto>findByTransactionType(String transactionType);
	  
	  
//	  @Query(nativeQuery = true,value="Select transactionID,amount,status,transactionCategory,transactionType,transactionDate,transactionMerchant from PhysicalGiftCardTransaction where transactionType=:val")
//	  List<PhysicalGitCardReponseDto>findByTransactionType(String val);
	  
}
