package com.novare.atm.service.impl;

import com.novare.atm.action.CreateUserAction;
import com.novare.atm.action.LoginMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;

public class WelcomeServiceImpl implements IWelcomeService {

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {

		switch (selectedOption) {
			case 0 -> {
				System.exit(0);
			}
			case 1 -> {
				new CreateUserAction(currentUser);
			}
			case 2 -> {
				new LoginMenuAction(currentUser);
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
