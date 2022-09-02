package com.novare.atm.action;

import com.novare.atm.controller.MainController;
import com.novare.atm.model.User;
import com.novare.atm.service.IMainService;
import com.novare.atm.service.impl.MainServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.MainView;

public class MainMenuAction extends BaseMenuAction {

	public MainMenuAction(MenuContext context, User currentUser) throws Exception {
		super(currentUser);
		MainView view = new MainView("Main Menu:");
		IMainService model = new MainServiceImpl();
		MainController controller = new MainController(model, view);
		controller.requestUserInput(context, currentUser);
	}

}
