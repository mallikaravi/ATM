package com.novare.atm.service.impl;

import com.novare.atm.action.DeleteUserAction;
import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.UpdatePasswordAction;
import com.novare.atm.action.UpdateUserAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

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
			new MainMenuAction(currentUser);
		}
		case 1 -> {
			new UpdateUserAction(currentUser);
		}
		case 2 -> {
			new DeleteUserAction(currentUser);
		}
		case 3 -> {
			new UpdatePasswordAction(currentUser);
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
