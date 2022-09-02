package com.novare.atm.service.impl;

import com.novare.atm.action.CreateUserAction;
import com.novare.atm.action.LoginMenuAction;
import com.novare.atm.action.MainMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;

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
				new CreateUserAction(currentUser);
			}
			case 2 -> {
				new LoginMenuAction(currentUser);
			}
			case 3 -> {
				new MainMenuAction(currentUser);
			}
	
			default -> throw new IndexOutOfBoundsException();
		}
	
	}

}
