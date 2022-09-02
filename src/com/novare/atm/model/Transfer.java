package com.novare.atm.model;

public class Transfer extends Transaction {
	private User sender;

	public Transfer(User user, TransactionType transactionType, double amount, User sender) {
		super(user, transactionType, amount);
		this.sender = sender;
	}

	/**
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

}
