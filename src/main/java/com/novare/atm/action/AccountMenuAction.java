package com.novare.atm.action;

import com.novare.atm.controller.AccountController;
import com.novare.atm.model.User;
import com.novare.atm.service.IAccountService;
import com.novare.atm.service.impl.AccountServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.AccountView;

public class AccountMenuAction extends BaseMenuAction {

	public AccountMenuAction(MenuContext context, User currentUser) throws Exception {
		super(context, currentUser);
		String title = "";
		switch (context) {
			case VIEW_BALANCE -> title = " View Balance and Last 10 Transactions:";
			case WITHDRAW_MONEY -> title = "Withdraw option:";
			case DEPOSIT_MONEY -> title = "Deposit option:";
			case TRANSFER_MONEY -> title = "Transfer your money:";
			default -> title = "Transaction Menu Options:";
		}

		AccountView view = new AccountView(title);
		IAccountService model = new AccountServiceImpl();
		AccountController controller = new AccountController(model, view);
		controller.setMenuVisible(context == MenuContext.ACCOUNT);
		controller.requestUserInput(context, currentUser);
	}
}
