package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;
import com.novare.atm.view.UserView;

public class UserController extends BaseController {

	public UserController(IUserService model, UserView view) {
		super(model, view);
	}

	@Override
	public IUserService getModel() {
		return (IUserService) super.getModel();
	}

	@Override
	public UserView getView() {
		return (UserView) super.getView();
	}

	@Override
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
					if (deleteUser()) {
						setUserSession(null);
						selectedOption = 4;
					}
				}
				default -> {
					int option = getView().getUserInput();
					selectedOption = option;
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

	private boolean deleteUser() throws Exception {
		boolean askConfirmation = getView().askUserDeletion();
		if (askConfirmation) {
			getModel().deleteUser(getUserSession());
			getView().printSuccessMessage();
			return true;
		}
		return false;
	}

	private void changePassword() throws Exception {
		String askUserPasswordToChange = getView().askUserPassword();
		if (!askUserPasswordToChange.isEmpty()) {
			getUserSession().setPassWord(ServiceUtil.encrypt(askUserPasswordToChange));
		}
		getModel().updatePassword(getUserSession());
		getView().printSuccessMessage();
		getView().waitForDecision();
	}

	private void updateProfile() throws Exception {
		String askUserNameToChange = getView().askUserName();
		if (!askUserNameToChange.isEmpty()) {
			getUserSession().setUserName(askUserNameToChange);
		}
		String askUserPasswordToChange = getView().askUserPassword();
		if (!askUserPasswordToChange.isEmpty()) {
			getUserSession().setPassWord(ServiceUtil.encrypt(askUserPasswordToChange));
		}
		getModel().updateUser(getUserSession());
		getView().printSuccessMessage();
		getView().waitForDecision();

	}

}
