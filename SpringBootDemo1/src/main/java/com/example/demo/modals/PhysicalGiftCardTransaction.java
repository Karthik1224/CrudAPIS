package com.example.demo.modals;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class PhysicalGiftCardTransaction {

	@Id
	@Column(name = "TransactionID", nullable = false, unique = true)
	private String transactionID;

	@Column(name = "Amount", nullable = false)
	private String amount;

	@Column(name = "RespCode", nullable = true)
	private String respCode;

	@Column(name = "RespMsg", nullable = true)
	private String respMsg;

	@Column(name = "ActionCode", nullable = true)
	private String actionCode;

	@Column(name = "AdjstBlncRespCode", nullable = true)
	private String adjstBlncRespCode;

	@Column(name = "AdjstBlncRespMsg", nullable = true)
	private String adjstBlncRespMsg;

	@Column(name = "AvlAmount", nullable = true)
	private BigDecimal avlAmount;

	@Column(name = "RunningBalance", nullable = true)
	private BigDecimal runningBalance;

	@Column(name = "Status", nullable = true)
	private String status;

	@Column(name = "prevTransactionStatus", nullable = true)
	private String prevTransactionStatus;

	@UpdateTimestamp
	@Column(name = "UpdatedOn", nullable = true)
	private Date updatedOn;

	@Column(name = "Fiid", nullable = true)
	private String fiid;

	@Column(name = "RecipientName", nullable = true)
	private String recipientName;

	@Column(name = "TerminalId", columnDefinition = "VARCHAR(30)", nullable = true)
	private String terminalId;

	@Column(name = "Vpan", columnDefinition = "VARCHAR(20)", nullable = true)
	private String vpan;

	@Column(name = "BankRRN", nullable = true)
	private String bankRRN;

	@Column(name = "TransactionCategory", nullable = true)
	private String transactionCategory;

	@Column(name = "TransactionDate", nullable = true)
	private Date transactionDate;

	@Column(name = "ResponseCode", nullable = true)
	private String responseCode;

	@Column(name = "Remarks", nullable = true)
	private String remarks;

	@Column(name = "TransactionType", nullable = true)
	private String transactionType;

	@Column(name = "Narrative", nullable = true)
	private String narrative;

	@Column(name = "CardNo", nullable = true)
	private String cardNo;

	@Column(name = "TransactionMerchant", nullable = true)
	private String transactionMerchant;

	// POS / ECOMM
	@Column(name = "TransactionMode", nullable = true)
	private String transactionMode;

	@Column(name = "ResponseDesc", nullable = true)
	private String responseDesc;

	@Column(name = "CardId", nullable = true)
	private String cardId;

	public BigDecimal getBlkAmount() {
		return blkAmount;
	}

	public void setBlkAmount(BigDecimal blkAmount) {
		this.blkAmount = blkAmount;
	}

	@Column(name = "BLKAmount", nullable = true)
	private BigDecimal blkAmount;

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getAdjstBlncRespCode() {
		return adjstBlncRespCode;
	}

	public void setAdjstBlncRespCode(String adjstBlncRespCode) {
		this.adjstBlncRespCode = adjstBlncRespCode;
	}

	public String getAdjstBlncRespMsg() {
		return adjstBlncRespMsg;
	}

	public void setAdjstBlncRespMsg(String adjstBlncRespMsg) {
		this.adjstBlncRespMsg = adjstBlncRespMsg;
	}

	public BigDecimal getAvlAmount() {
		return avlAmount;
	}

	public void setAvlAmount(BigDecimal avlAmount) {
		this.avlAmount = avlAmount;
	}

	public BigDecimal getRunningBalance() {
		return runningBalance;
	}

	public void setRunningBalance(BigDecimal runningBalance) {
		this.runningBalance = runningBalance;
	}

	public String getFiid() {
		return fiid;
	}

	public void setFiid(String fiid) {
		this.fiid = fiid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrevTransactionStatus() {
		return prevTransactionStatus;
	}

	public void setPrevTransactionStatus(String prevTransactionStatus) {
		this.prevTransactionStatus = prevTransactionStatus;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getVpan() {
		return vpan;
	}

	public void setVpan(String vpan) {
		this.vpan = vpan;
	}

	public String getBankRRN() {
		return bankRRN;
	}

	public void setBankRRN(String bankRRN) {
		this.bankRRN = bankRRN;
	}

	public String getTransactionCategory() {
		return transactionCategory;
	}

	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getTransactionMerchant() {
		return transactionMerchant;
	}

	public void setTransactionMerchant(String transactionMerchant) {
		this.transactionMerchant = transactionMerchant;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}