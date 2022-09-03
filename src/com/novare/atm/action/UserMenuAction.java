package com.novare.atm.action;

import com.novare.atm.controller.UserController;
import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.service.impl.UserServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.UserView;

public class UserMenuAction extends BaseMenuAction {

	public UserMenuAction(MenuContext context, User currentUser) throws Exception {
		super(context, currentUser);
		UserView view = new UserView("User Profile Menu:");
		IUserService model = new UserServiceImpl();
		UserController controller = new UserController(model, view);
		controller.setMenuVisible(context == MenuContext.USER);
		controller.requestUserInput(context, currentUser);

	}

}
