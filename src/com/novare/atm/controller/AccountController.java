package com.novare.atm.controller;

import javax.naming.InsufficientResourcesException;

import com.novare.atm.model.Account;
import com.novare.atm.model.Transaction;
import com.novare.atm.model.TransactionType;
import com.novare.atm.model.User;
import com.novare.atm.service.IAccountService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.AccountView;

public class AccountController extends BaseController {

	public AccountController(IAccountService model, AccountView view) {
		super(model, view);
	}

	public IAccountService getModel() {
		return (IAccountService) super.getModel();
	}

	public AccountView getView() {
		return (AccountView) super.getView();
	}

	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
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
				case TRANSFER_MONEY -> {
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

	private void transferMoney() throws Exception {
		String senderName = getView().askSenderDetails();
		User sender = getModel().findByUserName(senderName);
		if (sender == null) {
			getView().printMessage("User Not Found");
			throw new Exception("User Not Found");
		}
		double transferAmount = getView().askTransferAmount();

		// This is the withdraw transaction type to withdraw money from our account
		Transaction transaction = new Transaction(TransactionType.TRANSFER, transferAmount);
		transaction.setSenderName(sender.getUserName());
		Account account = getUserSession().getAccount();
		if (transferAmount > account.getBalance()) {
			throw new InsufficientResourcesException();
		}
		account.setBalance(account.getBalance() - transferAmount);
		account.addTransaction(transaction);
		getModel().updateUser(getUserSession());

		// This transaction type is to deposit money from our account(Sending money to
		// other user account)
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transaction.setSenderName(getUserSession().getUserName());
		Account senderAccount = sender.getAccount();
		senderAccount.setBalance(senderAccount.getBalance() + transferAmount);
		senderAccount.addTransaction(transaction);
		getModel().updateUser(sender);
		getView().waitForDecision();
	}

	private void withdrawMoney() throws Exception {
		double withdrawAmount = getView().askWithdrawAmount();
		Transaction transaction = new Transaction(TransactionType.WITHDRAW, withdrawAmount);
		transaction.setSenderName(getUserSession().getUserName());
		Account account = getUserSession().getAccount();
		if (withdrawAmount > account.getBalance()) {
			throw new InsufficientResourcesException();
		}
		account.setBalance(account.getBalance() - withdrawAmount);
		account.addTransaction(transaction);
		getModel().updateUser(getUserSession());
		getView().waitForDecision();
	}

	private void depositMoney() throws Exception {
		double depositAmount = getView().askUserDepositAmount();
		Transaction transaction = new Transaction(TransactionType.DEPOSIT, depositAmount);
		transaction.setSenderName(getUserSession().getUserName());
		Account account = getUserSession().getAccount();
		account.setBalance(account.getBalance() + depositAmount);
		account.addTransaction(transaction);
		getModel().updateUser(getUserSession());
		getView().waitForDecision();
	}

	private void viewBalance() throws Exception {
		Account account = getUserSession().getAccount();
		getView().showBalance(account.getBalance());
		getView().waitForDecision();
	}

}
