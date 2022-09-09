package com.novare.atm.controller;

import java.io.FileNotFoundException;

import javax.security.sasl.AuthenticationException;

import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;
import com.novare.atm.view.WelcomeView;

public class WelcomeController extends BaseController {
	private User newUser = new User();

	public WelcomeController(IWelcomeService model, WelcomeView view) {
		super(model, view);
	}

	@Override
	public IWelcomeService getModel() {
		return (IWelcomeService) super.getModel();
	}

	@Override
	public WelcomeView getView() {
		return (WelcomeView) super.getView();
	}

	@Override
	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		try {
			super.requestUserInput(context, currentUser);
			int selectedOption = 0;
			switch (context) {
				case SIGNUP -> {
					createUser();
					selectedOption = 2;
				}
				case LOGIN -> {
					try {
						login();
						selectedOption = 3;
					} catch (AuthenticationException e) {
						selectedOption = 4;
					}
				}
				case LOGOUT -> {
					selectedOption = 4;
				}
				default -> {
					selectedOption = getView().getUserInput();
				}
			}
			getModel().handleOption(selectedOption, getUserSession());
		} catch (FileNotFoundException e) {
			getView().printMessage(e.getMessage());
			getView().goodBye();
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}
	}

	private void login() throws Exception {
		if (newUser.getUserName() == null) {
			newUser.setUserName(getView().askUserName());
		}
		if (newUser.getPassWord() == null) {
			newUser.setPassWord(ServiceUtil.encrypt(getView().askUserPassword()));
		}
		User login = getModel().login(newUser);
		if (login == null) {
			if (getView().askForSignUp()) {
				throw new AuthenticationException();
			}
		}
		setUserSession(login);

	}

	/**
	 * this method is used to create a user by sign up
	 * 
	 * @throws Exception
	 */
	private void createUser() throws Exception {
		if (newUser.getFullName() == null) {
			newUser.setFullName(getView().askUserFullName());
		}

		if (newUser.getUserName() == null) {
			newUser.setUserName(getView().askUserName());
			if (getModel().isValidUser(newUser)) {
				newUser.setUserName("");
				throw new Exception("User Already exist !");
			}
		}
		if (newUser.getPassWord() == null) {
			newUser.setPassWord(ServiceUtil.encrypt(getView().askUserPassword()));
		}
		getModel().createUser(newUser);

	}

}
