package com.novare.atm.service.impl;

import java.util.List;

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

}
