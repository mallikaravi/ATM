package com.novare.atm.service.impl;

import java.util.Iterator;
import java.util.List;

import com.novare.atm.model.Account;
import com.novare.atm.model.User;
import com.novare.atm.service.IBaseService;
import com.novare.atm.util.ServiceUtil;

public abstract class BaseServiceImpl implements IBaseService {

	@Override
	public boolean isValidUser(User current) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		return users.contains(current);
	}

	@Override
	public User findByUserName(String userName) throws Exception {
		List<User> users = ServiceUtil.loadUsers();
		for (User user : users) {
			if (user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}

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
		user.setPassWord(user.getPassWord());
		users.add(user);
		ServiceUtil.saveUsers(users);
		return user;
	}

	@Override
	public User updatePassword(User user) throws Exception {
		return updateUser(user);
	}

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
}
