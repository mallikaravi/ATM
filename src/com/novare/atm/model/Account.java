package com.novare.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private double balance;
	private List<Transaction> transactions = new ArrayList<>();

	public Account() {
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
	}

}
