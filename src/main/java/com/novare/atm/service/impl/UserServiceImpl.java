package com.novare.atm.service.impl;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.util.MenuContext;

public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	

	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
			case 0 -> {
				new MainMenuAction(MenuContext.MAIN, currentUser);
			}
			case 1 -> {
				new UserMenuAction(MenuContext.UPDATE_USER, currentUser);
			}
			case 2 -> {
				new UserMenuAction(MenuContext.CHANGE_PASSWORD, currentUser);
			}
			case 3 -> {
				new UserMenuAction(MenuContext.DELETE_USER, currentUser);
			}
			case 4 -> {
				new WelcomeMenuAction(MenuContext.WELCOME, currentUser);
			}
			default -> throw new IndexOutOfBoundsException();
		}
	}
}
