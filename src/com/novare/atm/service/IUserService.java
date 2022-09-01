package com.novare.atm.service;

import com.novare.atm.model.Bank;
import com.novare.atm.model.User;

public interface IUserService extends IBankService {

	/**
	 * This is the method to view the balance
	 * 
	 * @param bank
	 * @return
	 */
	User viewBalance(Bank bank);

	/**
	 * This is the method to withdraw cash from the bank
	 * 
	 * @param bank
	 * @return
	 */
	User withdrawMoney(Bank bank);

	/**
	 * THis is the method to deposit cash
	 * 
	 * @param bank
	 * @return
	 */
	User depositMoney(Bank bank);

	/**
	 * This method is used to transfer cash from one account to another
	 * 
	 * @param bank
	 * @return
	 */
	User transferMoney(Bank bank);

}
