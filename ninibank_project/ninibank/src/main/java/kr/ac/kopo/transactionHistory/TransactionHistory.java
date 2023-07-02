package kr.ac.kopo.transactionHistory;

import java.util.Date;

public class TransactionHistory {
	private String transactionId;     
    private String accountNumber;     
    private Date transactionDate;    
    private Date transactiontime;
	private String transactionType;   
    private Long amount;
    private String SenderName;
    private String RecipientName;
    private String  bankCode;
    
    
	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionDate=" + transactionDate + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", SenderName=" + SenderName + ", RecipientName=" + RecipientName + ", bankCode=" + bankCode + "]";
	}
	public Date getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(Date transactiontime) {
		this.transactiontime = transactiontime;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getRecipientName() {
		return RecipientName;
	}
	public void setRecipientName(String recipientName) {
		RecipientName = recipientName;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}            
}
