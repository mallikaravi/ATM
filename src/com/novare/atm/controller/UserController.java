package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.UserView;

public class UserController extends BaseController {

	public UserController(IUserService model, UserView view) {
		super(model, view);
	}

	public IUserService getModel() {
		return (IUserService) super.getModel();
	}

	public UserView getView() {
		return (UserView) super.getView();
	}

	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		try {
			super.requestUserInput(context, currentUser);
			int selectedOption = 0;
			switch (context) {
				case UPDATE_USER -> {
					updateProfile();
					selectedOption = 4;
				}
				case CHANGE_PASSWORD -> {
					changePassword();
					selectedOption = 4;
				}
				case DELETE_USER -> {
					deleteUser();
					setUserSession(null);
					selectedOption = 4;
				}
				default -> {
					selectedOption = getView().getUserInput();
				}
			}
			getModel().handleOption(selectedOption, getUserSession());
		} catch (Exception e) {
			getView().printInvalidOption();
			getView().printUserRequest();
			setMenuVisible(false);
			requestUserInput(context, currentUser);
		}
	}

	private void deleteUser() throws Exception {
		boolean askConfirmation = getView().askUserDeletion();
		if (askConfirmation) {
			getModel().deleteUser(getUserSession());
		}
	}

	private void changePassword() throws Exception {
		String askUserPasswordToChange = getView().askUserPassword();
		if (!askUserPasswordToChange.isEmpty()) {
			getUserSession().setPassWord(askUserPasswordToChange);
		}
		getModel().updatePassword(getUserSession());
	}

	private void updateProfile() throws Exception {
		String askUserNameToChange = getView().askUserName();
		if (!askUserNameToChange.isEmpty()) {
			getUserSession().setUserName(askUserNameToChange);
		}
		String askUserPasswordToChange = getView().askUserPassword();
		if (!askUserPasswordToChange.isEmpty()) {
			getUserSession().setPassWord(askUserPasswordToChange);
		}
		getModel().updateUser(getUserSession());
	}

}
