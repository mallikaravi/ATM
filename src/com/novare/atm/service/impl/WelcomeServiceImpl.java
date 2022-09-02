package com.novare.atm.service.impl;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.util.MenuContext;

public class WelcomeServiceImpl implements IWelcomeService {

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidUser(User current) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {

		switch (selectedOption) {
		case 0 -> {
			System.exit(0);
		}
		case 1 -> {
			new WelcomeMenuAction(MenuContext.SIGNUP, currentUser);
		}
		case 2 -> {
			new WelcomeMenuAction(MenuContext.LOGIN, currentUser);
		}
		case 3 -> {
			new MainMenuAction(MenuContext.MAIN, currentUser);
		}

		default -> throw new IndexOutOfBoundsException();
		}

	}

}
