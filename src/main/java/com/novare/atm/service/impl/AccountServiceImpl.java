package com.novare.atm.service.impl;

import com.novare.atm.action.AccountMenuAction;
import com.novare.atm.action.MainMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IAccountService;
import com.novare.atm.util.MenuContext;

public class AccountServiceImpl extends UserServiceImpl implements IAccountService {

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
			case 0 -> {
				new MainMenuAction(MenuContext.MAIN, currentUser);
			}
			case 1 -> {
				new AccountMenuAction(MenuContext.VIEW_BALANCE, currentUser);
			}
			case 2 -> {
				new AccountMenuAction(MenuContext.DEPOSIT_MONEY, currentUser);
			}
			case 3 -> {
				new AccountMenuAction(MenuContext.WITHDRAW_MONEY, currentUser);

			}
			case 4 -> {
				new AccountMenuAction(MenuContext.TRANSFER_MONEY, currentUser);

			}
			default -> throw new IndexOutOfBoundsException();
		}

	}

}
