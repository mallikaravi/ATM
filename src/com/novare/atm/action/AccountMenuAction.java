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
		AccountView view = new AccountView("Transaction Menu Options:");
		IAccountService model = new AccountServiceImpl();
		AccountController controller = new AccountController(model, view);
		controller.setMenuVisible(context == MenuContext.ACCOUNT);
		controller.requestUserInput(context, currentUser);
	}
}
