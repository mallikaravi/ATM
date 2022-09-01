package com.novare.atm.view;

import java.util.List;

import com.novare.atm.util.PrintHandler;

public class UserView extends BaseView {

	public UserView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return null;
	}

	public void printNavigationMenu() {
		PrintHandler.optionBackToMainMenu();
	}

}
