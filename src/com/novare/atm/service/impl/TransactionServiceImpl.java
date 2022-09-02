package com.novare.atm.service.impl;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.TransactionMenuAction;
import com.novare.atm.model.Transaction;
import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;
import com.novare.atm.util.MenuContext;

public class TransactionServiceImpl implements ITransactionService {

	@Override
	public Transaction viewBalance(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction withdrawMoney(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction depositMoney(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction transferMoney(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction(MenuContext.MAIN, currentUser);
		}
		case 1 -> {
			new TransactionMenuAction(MenuContext.DEPOSIT_MONEY, currentUser);
		}
		case 2 -> {
		}
		case 3 -> {
		}
		case 4 -> {
		}

		default -> throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public boolean isValidUser(User current) throws Exception {
		return false;
	}

}
