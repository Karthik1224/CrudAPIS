package com.example.demo.responseDTOS;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
public class PhysicalGitCardReponseDto {

	public String transactionID;
	public String amount;
	public String status;
	public String transactionCategory;
	public String transactionType;
	public Date transactionDate;
	public String transactionMerchant;
	public PhysicalGitCardReponseDto(String transactionID, String amount, String status, String transactionCategory,
			String transactionType, Date transactionDate, String transactionMerchant) {
		super();
		this.transactionID = transactionID;
		this.amount = amount;
		this.status = status;
		this.transactionCategory = transactionCategory;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionMerchant = transactionMerchant;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public String getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	public String getTransactionCategory() {
		return transactionCategory;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public String getTransactionMerchant() {
		return transactionMerchant;
	}
	


}
