package com.novare.atm.view;

import java.util.List;

import javax.naming.InsufficientResourcesException;

import com.novare.atm.util.PrintHandler;

public class AccountView extends BaseView {

	public AccountView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("View Balance", "Deposit", "Withdraw", "Transfer");
	}

	public void printNavigationMenu() {
		PrintHandler.optionBackToMainMenu();
	}

	public double askUserDepositAmount() {
		printMessage("Please Enter the amount you want to deposit: ");
		try {
			return getUserEnteredAmount();
		} catch (Exception exception) {
			printInvalidOption();
			printUserRequest();
			return askUserDepositAmount();
		}
	}

	public void showBalance(double balance) {
		printMessage("Available balance: " + balance);
	}

	public double askWithdrawAmount() {
		printMessage("Please Enter the amount you want to withdraw: ");
		try {
			return getUserEnteredAmount();
		} catch (Exception exception) {
			printInvalidOption();
			printUserRequest();
			return askWithdrawAmount();
		}
	}

	public String askSenderDetails() {
		printMessage("Enter account holder details: ");
		return getUserText();
	}

	public double askTransferAmount() {
		printMessage("Enter amount: ");
		try {
			return getUserEnteredAmount();
		} catch (Exception exception) {
			printInvalidOption();
			printUserRequest();
			return askTransferAmount();
		}
	}

	private double getUserEnteredAmount() throws InsufficientResourcesException {
		String userText = getUserText();
		double amount = Double.parseDouble(userText);
		if (amount < 1) {
			throw new InsufficientResourcesException();
		}
		return amount;
	}
}
