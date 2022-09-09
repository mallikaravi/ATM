package com.novare.atm.view;

import java.util.List;

import com.novare.atm.util.PrintHandler;

public class UserView extends BaseView {

	public UserView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("Edit Profile", "Change Password", "Delete Profile");
	}

	public void printNavigationMenu() {
		PrintHandler.optionBackToMainMenu();
	}

	public boolean askUserDeletion() {
		printMessage("Do you want to delete the current user [Yes/No]: ");
		return askConfirmationYesOrNo();
	}
	public void printSuccessMessage() {
		printMessage("Data saved successfully !");
	}
}
