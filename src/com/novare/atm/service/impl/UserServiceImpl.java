package com.novare.atm.service.impl;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.util.MenuContext;

public class UserServiceImpl implements IUserService {

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
		case 0 -> {
			new MainMenuAction(MenuContext.MAIN, currentUser);
		}
		case 1 -> {
			new UserMenuAction(MenuContext.UPDATE, currentUser);
		}
		case 2 -> {
		}
		case 3 -> {
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
