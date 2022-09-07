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
		String title = "";
		switch (context) {
			case UPDATE_USER -> title = "Edit Profile Option";
			case CHANGE_PASSWORD -> title = "Change Password Option";
			case DELETE_USER -> title = "Delete User Option";
			default -> title = "UserProfile Menu options";
		}
		UserView view = new UserView(title);
		IUserService model = new UserServiceImpl();
		UserController controller = new UserController(model, view);
		controller.setMenuVisible(context == MenuContext.USER);
		controller.requestUserInput(context, currentUser);

	}

}
