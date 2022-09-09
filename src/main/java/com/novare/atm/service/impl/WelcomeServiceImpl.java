package com.novare.atm.service.impl;

import java.util.List;

import com.novare.atm.action.MainMenuAction;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.Account;
import com.novare.atm.model.User;
import com.novare.atm.service.IWelcomeService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.util.ServiceUtil;

public class WelcomeServiceImpl extends BaseServiceImpl implements IWelcomeService {

	@Override
	public User createUser(User user) throws Exception {
		ServiceUtil.checkAssetFolder();
		List<User> users = ServiceUtil.loadUsers();
		user.setPassWord(user.getPassWord());
		Account account = new Account();
		user.setAccount(account);
		users.add(user);
		ServiceUtil.saveUsers(users);
		return user;
	}

	@Override
	public User login(User user) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		for (User cache : users) {
			boolean userName = cache.getUserName().equals(user.getUserName());
			boolean password = cache.getPassWord().equals(user.getPassWord());
			if (userName && password) {
				return cache;
			}
		}
		return null;
	}

	@Override
	public void handleOption(int selectedOption, User currentUser) throws Exception {
		switch (selectedOption) {
			case 0 -> {
				System.exit(0);
			}
			case 1 -> {
				new WelcomeMenuAction(MenuContext.SIGNUP, currentUser);
			}
			case 2 -> {
				new WelcomeMenuAction(MenuContext.LOGIN, currentUser);
			}
			case 3 -> {
				new MainMenuAction(MenuContext.MAIN, currentUser);
			}
			case 4 -> {
				new WelcomeMenuAction(MenuContext.WELCOME, null);
			}

			default -> throw new IndexOutOfBoundsException();
		}
	}
}
