package com.novare.atm.service;

import com.novare.atm.model.User;

public interface IUserService extends IBaseService {

	User deleteUser(User user) throws Exception;

	User updateUser(User user) throws Exception;

	User updatePassword(User user) throws Exception;

}
