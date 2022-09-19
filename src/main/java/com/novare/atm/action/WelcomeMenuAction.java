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

		// This if/else should be handle elsewhere. WelcomeMenuAction should only initialize the MVC pattern and nothing else.
		// Then we can use the model to verify any data and show something else if needed.
		if (context == null) {
			context = MenuContext.WELCOME;
		} else if (context == MenuContext.LOGIN) {
			view.setTitle("Login menu options:");
		}

		controller.setMenuVisible(context == MenuContext.WELCOME);
		controller.requestUserInput(context, currentUser);

	}
}
