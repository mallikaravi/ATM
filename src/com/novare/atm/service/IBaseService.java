package com.novare.atm.service;

import com.novare.atm.model.User;

public interface IBaseService {
	void handleOption(int selectedOption, User currentUser) throws Exception;

	boolean isValidUser(User current) throws Exception;

}
