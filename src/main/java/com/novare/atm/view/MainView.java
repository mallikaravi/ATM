package com.novare.atm.view;

import java.util.List;

import com.novare.atm.util.PrintHandler;

public class MainView extends BaseView {

	public MainView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("User Profile","ATM Transactions");
	}

	public void printNavigationMenu() {
		PrintHandler.optionLogout();
	}
}


