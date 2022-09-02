package com.novare.atm.service.impl;

import com.novare.atm.action.BankMenuAction;
import com.novare.atm.action.LogOutMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;

public class MainServiceImpl implements IWelcomeService {

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {

		switch (selectedOption) {
			case 0 -> {
				new LogOutMenuAction(currentUser);
			}
			case 1 -> {
				new UserMenuAction(currentUser);
			}
			case 2 -> {
				new BankMenuAction(currentUser);
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
