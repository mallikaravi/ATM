package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.TransactionView;

public class TransactionController extends BaseController {

	public TransactionController(ITransactionService model, TransactionView view) {
		super(model, view);
	}

	public ITransactionService getModel() {
		return (ITransactionService) super.getModel();
	}

	public TransactionView getView() {
		return (TransactionView) super.getView();
	}

	public void requestTransactionInput(MenuContext context, User currentUser) throws Exception {
		try {
			super.requestUserInput(context, currentUser);
			int selectedOption = 0;
			switch (context) {
				case VIEW_BALANCE -> {
					viewBalance();
					
				}
				case DEPOSIT_MONEY -> {
					depositMoney();
					
				}
				case WITHDRAW_MONEY -> {
					withdrawMoney();
					
				}
				case TRANSFER_MONEY ->{
					transferMoney();
					
				}
				default -> {
					selectedOption = getView().getUserInput();
				}
			}
			getModel().handleOption(selectedOption, getUserSession());
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}
	}

	private void transferMoney() {
		// TODO Auto-generated method stub
		
	}

	private void withdrawMoney() {
		// TODO Auto-generated method stub
		
	}

	private void depositMoney() {
		// TODO Auto-generated method stub
		
	}

	private void viewBalance() {
		// TODO Auto-generated method stub
		
	}

}
