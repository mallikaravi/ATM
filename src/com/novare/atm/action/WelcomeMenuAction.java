package com.novare.atm.action;

import com.novare.atm.controller.WelcomeController;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.service.impl.WelcomeServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.WelcomeView;

public class WelcomeMenuAction extends BaseMenuAction {

	public WelcomeMenuAction(User currentUser) throws Exception {
		super(currentUser);
		WelcomeView view = new WelcomeView("Welcome to ABC Bank ATM");
		IWelcomeService model = new WelcomeServiceImpl();
		WelcomeController controller = new WelcomeController(model, view);
		controller.requestUserInput(MenuContext.WELCOME, currentUser);

	}
}
