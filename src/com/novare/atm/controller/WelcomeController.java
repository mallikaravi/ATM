package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.WelcomeView;

public class WelcomeController extends BaseController {

	public WelcomeController(IWelcomeService model, WelcomeView view) {
		super(model, view);
	}

	public IWelcomeService getModel() {
		return (IWelcomeService) super.getModel();
	}

	public WelcomeView getView() {
		return (WelcomeView) super.getView();
	}

	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		super.requestUserInput(context, currentUser);
		try {
			int userInput = getView().getUserInput();
			getModel().handleOption(userInput, currentUser);
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}

	}
}
