package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.WelcomeView;

public class WelcomeController extends BaseController {
	private User newUser;

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
		try {
			int selectedOption = 0;
			switch (context) {
				case SIGNUP -> {
					createUser();
					selectedOption = 2;
				}
				case LOGIN -> {
					login();
					selectedOption =3;
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

	private void login() {
		if (newUser.getUserName() == null) {
			newUser.setUserName(getView().askUserName());
		}
		if (newUser.getPassWord() == null) {
			newUser.setPassWord(getView().askUserPassword());
		}
		getModel().login(newUser);
	

	}

	private void createUser() {
		if (newUser.getFullName() == null) {
			newUser.setFullName(getView().askUserFullName());
		}
		if (newUser.getUserName() == null) {
			newUser.setUserName(getView().askUserName());
		}
		if (newUser.getPassWord() == null) {
			newUser.setPassWord(getView().askUserPassword());
		}
		getModel().createUser(newUser);
		
	}

}
