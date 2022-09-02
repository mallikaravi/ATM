package com.novare.atm.action;

import com.novare.atm.model.User;

public abstract class BaseMenuAction {
	private User currentUser;

	public BaseMenuAction(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
