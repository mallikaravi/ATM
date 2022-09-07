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

	@Override
	public IMainService getModel() {
		return (IMainService) super.getModel();
	}

	@Override
	public MainView getView() {
		return (MainView) super.getView();
	}

	@Override
	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		try {
			super.requestUserInput(context, currentUser);
			int selectedOption = getView().getUserInput();
			getModel().handleOption(selectedOption, currentUser);
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}

	}
}
