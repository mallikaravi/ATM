package com.novare.atm.view;

import java.util.List;

import com.novare.atm.util.PrintHandler;

public class WelcomeView extends BaseView {

	public WelcomeView(String title) {
		super(title);
	}

	@Override
	public List<String> getMenuOptions() {
		return List.of("SignUp", "Login");
	}

	public void printNavigationMenu() {
		PrintHandler.optionQuit();
	}

}
