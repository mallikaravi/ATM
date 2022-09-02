package com.novare.atm.controller;

import javax.security.sasl.AuthenticationException;

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
		if (!getModel().isValidUser(currentUser)) {
			throw new AuthenticationException();
		}
	}

}
