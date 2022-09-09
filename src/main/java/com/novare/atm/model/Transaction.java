package com.novare.atm.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.novare.atm.util.DateUtil;

public class Transaction implements Comparable<Transaction> {
	private TransactionType transactionType;
	private double amount;
	private String senderName;
	private Date date;

	public Transaction() {
	}

	public Transaction(TransactionType transactionType, double amount) {
		super();
		this.date = DateUtil.toDate(LocalDateTime.now());
		this.transactionType = transactionType;
		this.amount = amount;
		this.senderName = "Self";
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	@Override
	public int compareTo(Transaction transaction) {
		return transaction.getDate().compareTo(getDate());
	}

}
