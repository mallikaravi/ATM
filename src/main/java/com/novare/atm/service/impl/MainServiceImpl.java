package com.novare.atm.service.impl;

import com.novare.atm.action.AccountMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IMainService;
import com.novare.atm.util.MenuContext;

public class MainServiceImpl extends BaseServiceImpl implements IMainService {

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
				new AccountMenuAction(MenuContext.ACCOUNT, currentUser);
			}

			default -> throw new IndexOutOfBoundsException();
		}
	}
}
