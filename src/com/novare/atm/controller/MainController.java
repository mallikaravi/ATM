package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IBaseService;
import com.novare.atm.service.IMainService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.BaseView;
import com.novare.atm.view.MainView;

public class MainController extends BaseController {

	public MainController(IBaseService model, BaseView view) {
		super(model, view);
	}

	public IMainService getModel() {
		return (IMainService) super.getModel();
	}

	public MainView getView() {
		return (MainView) super.getView();
	}

	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		try {
			int selectedOption = 0;
			switch (context) {
			case USER -> {
			}
			case TRANSACTION -> {
			}
			default -> {
				super.requestUserInput(context, currentUser);
				selectedOption = getView().getUserInput();
			}
			}
			getModel().handleOption(selectedOption, currentUser);
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}

	}
}
