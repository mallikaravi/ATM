package com.novare.atm.service;

import com.novare.atm.model.User;

public interface IWelcomeService extends IBaseService {

	User login(User user) throws Exception;

	User createUser(User user) throws Exception;

}
