package com.novare.atm.service;

import com.novare.atm.model.User;

public interface IBaseService {

	void handleOption(int selectedOption, User currentUser) throws Exception;

	boolean isValidUser(User current) throws Exception;

	User findByUserName(String userName) throws Exception;

	User deleteUser(User user) throws Exception;

	User updateUser(User user) throws Exception;

	User updatePassword(User user) throws Exception;

	User login(User user) throws Exception;

	User createUser(User user) throws Exception;

}
