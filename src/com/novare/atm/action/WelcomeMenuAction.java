package com.novare.atm.action;

import com.novare.atm.controller.WelcomeController;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.service.impl.WelcomeServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.WelcomeView;

public class WelcomeMenuAction extends BaseMenuAction {

	public WelcomeMenuAction(MenuContext context, User currentUser) throws Exception {
		super(context, currentUser);
		WelcomeView view = new WelcomeView("Welcome to ABC Bank ATM");
		IWelcomeService model = new WelcomeServiceImpl();
		WelcomeController controller = new WelcomeController(model, view);
		if (context == null) {
			context = MenuContext.WELCOME;
		}
		controller.requestUserInput(context, currentUser);

	}
}
