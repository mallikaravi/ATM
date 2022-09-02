package com.novare.atm.service.impl;

import com.novare.atm.action.DepositMenuAction;
import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.TransferMenuAction;
import com.novare.atm.action.ViewBalanceMenuAction;
import com.novare.atm.action.WithdrawMenuAction;
import com.novare.atm.model.Transaction;
import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;

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
				new MainMenuAction(currentUser);
			}
			case 1 -> {
				new ViewBalanceMenuAction(currentUser);
			}
			case 2 -> {
				new DepositMenuAction(currentUser);
			}
			case 3 -> {
				new WithdrawMenuAction(currentUser);
			}
			case 4 -> {
				new TransferMenuAction(currentUser);
			}

			default -> throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public boolean isValidUser(User current) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
