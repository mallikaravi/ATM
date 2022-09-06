package com.novare.atm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.novare.atm.util.DateUtil;

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

	public String printTransactions() {

		StringBuilder builder = new StringBuilder();
		builder.append(String.format("| %62s |%n", "").replace(' ', '-'));
		builder.append(String.format("| Hello, %s |%n", "%-55s"));
		builder.append(String.format("| %-19s:%42s |%n", "Available Balance", String.valueOf(getBalance())));

		builder.append(String.format("| %62s |%n", "").replace(' ', '-'));
		builder.append(
				String.format("| %-5s| %-10s| %-20s| %-10s| %10s|%n", "S.No", "Type", "Date", "Sender", "Amount"));
		builder.append(String.format("| %62s |%n", "").replace(' ', '-'));

		Collections.sort(getTransactions());
		int size = getTransactions().size() > 10 ? 10 : getTransactions().size();
		for (int i = 0; i < size; i++) {
			Transaction transaction = getTransactions().get(i);
			String numericalSign = "";
			switch (transaction.getTransactionType()) {
				case TRANSFER -> numericalSign = "-";
				case WITHDRAW -> numericalSign = "-";
				default -> numericalSign = "+";
			}
			builder.append(String.format("| %-5d| %-10s| %-20s| %-10s| %10s|%n", (i + 1),
					transaction.getTransactionType(), DateUtil.toString(transaction.getDate()),
					transaction.getSenderName().toUpperCase(), numericalSign + transaction.getAmount()));
		}
		builder.append(String.format("| %62s |%n", "").replace(' ', '-'));
		return builder.toString();
	}
}
