package com.novare.atm.service;

import com.novare.atm.model.User;

public interface IUserService extends IBaseService {

	User createUser(User user);

	User deleteUser(User user);

	User updateUser(User user);

	User updatePassword(User user);

}
