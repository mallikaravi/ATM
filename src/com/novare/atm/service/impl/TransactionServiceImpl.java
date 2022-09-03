package com.novare.atm.service.impl;

import java.util.List;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.TransactionMenuAction;
import com.novare.atm.model.Transaction;
import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;

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
				new TransactionMenuAction(MenuContext.VIEW_BALANCE,currentUser);
			}
			case 3 -> {
				new TransactionMenuAction(MenuContext.WITHDRAW_MONEY,currentUser);

			}
			case 4 -> {
				new TransactionMenuAction(MenuContext.TRANSFER_MONEY,currentUser);

			}
			
			default -> throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public boolean isValidUser(User current) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		return users.contains(current);
	}

}
