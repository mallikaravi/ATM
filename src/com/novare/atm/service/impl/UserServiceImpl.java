package com.novare.atm.service.impl;

import java.util.Iterator;
import java.util.List;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.UserMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.service.IUserService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;

public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	@Override
	public User deleteUser(User user) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		users.remove(user);
		ServiceUtil.saveUsers(users);
		return user;
	}

	@Override
	public User updateUser(User user) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User next = iterator.next();
			if (next.getFullName().equals(user.getFullName())) {
				iterator.remove();
			}
		}
		users.add(user);
		ServiceUtil.saveUsers(users);
		return user;
	}

	@Override
	public User updatePassword(User user) throws Exception {
		return updateUser(user);
	}

	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
			case 0 -> {
				new MainMenuAction(MenuContext.MAIN, currentUser);
			}
			case 1 -> {
				new UserMenuAction(MenuContext.UPDATE_USER, currentUser);
			}
			case 2 -> {
				new UserMenuAction(MenuContext.CHANGE_PASSWORD, currentUser);
			}
			case 3 -> {
				new UserMenuAction(MenuContext.DELETE_USER, currentUser);
			}
			case 4 -> {
				new WelcomeMenuAction(MenuContext.WELCOME, currentUser);
			}
			default -> throw new IndexOutOfBoundsException();
		}
	}
}
