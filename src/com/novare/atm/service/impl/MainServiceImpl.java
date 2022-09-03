package com.novare.atm.service.impl;

import java.util.List;

import com.novare.atm.action.TransactionMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IMainService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;

public class MainServiceImpl implements IMainService {

	@Override
	public boolean isValidUser(User current) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		return users.contains(current);
	}

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {

		switch (selectedOption) {
			case 0 -> {
				new WelcomeMenuAction(MenuContext.LOGOUT, currentUser);
			}
			case 1 -> {
				new UserMenuAction(MenuContext.USER, currentUser);
			}
			case 2 -> {
				new TransactionMenuAction(MenuContext.TRANSACTION, currentUser);
			}

			default -> throw new IndexOutOfBoundsException();
		}

	}

}
