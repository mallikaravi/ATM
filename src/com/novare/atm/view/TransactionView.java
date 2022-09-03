package com.novare.atm.view;

import java.util.List;

import com.novare.atm.util.PrintHandler;

public class TransactionView extends BaseView {

	public TransactionView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("View Balance","Deposit","Withdraw","Transfer");
	}

	public void printNavigationMenu() {
		PrintHandler.optionBackToMainMenu();
	}
	public  boolean askUserDeposit() {
		printMessage("Do you want to deposit money [Yes/No]:");
		return askConfirmationYesOrNo();
		
	}
	public  boolean askUserViewBalance() {
		printMessage("Do you want to view [Yes/No]:");
		return askConfirmationYesOrNo();
		
	}
	public  boolean askUserWithdraw() {
		printMessage("Do you want to withdraw money [Yes/No]:");
		return askConfirmationYesOrNo();
		
	}
	public  boolean askUserTransfer() {
		printMessage("Do you want to transfer money [Yes/No]:");
		return askConfirmationYesOrNo();
		
	}
}


