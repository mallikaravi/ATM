package com.novare.atm.service;

import com.novare.atm.model.Transaction;

public interface ITransactionService extends IBaseService {


	/**
	 * This is the method to view the balance
	 * 
	 * @param transaction
	 * @return
	 */
	Transaction viewBalance(Transaction transaction);

	/**
	 * This is the method to withdraw cash from the bank
	 * 
	 * @param bank
	 * @return
	 */
	Transaction withdrawMoney(Transaction transaction);

	/**
	 * THis is the method to deposit cash
	 * 
	 * @param transaction
	 * @return
	 */
	Transaction depositMoney(Transaction transaction);

	/**
	 * This method is used to transfer cash from one account to another
	 * 
	 * @param transaction
	 * @return
	 */
	Transaction transferMoney(Transaction transaction);

}
