package com.novare.atm.controller;

import com.novare.atm.model.User;
import com.novare.atm.service.IBaseService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.BaseView;

public class BaseController {

	private IBaseService model;
	private BaseView view;
	private boolean menuVisible;

	public BaseController(IBaseService model, BaseView view) {
		setModel(model);
		setView(view);
		setMenuVisible(true);
	}

	public void requestUserInput(MenuContext context, User currentUser) throws Exception {
		if (isMenuVisible()) {
			getView().setMenuOptions(getView().getMenuOptions());
			getView().printUserRequest();
		}
	}

	/**
	 * @return the model
	 */
	public IBaseService getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(IBaseService model) {
		this.model = model;
	}

	/**
	 * @return the menuVisible
	 */
	public boolean isMenuVisible() {
		return menuVisible;
	}

	/**
	 * @param menuVisible the menuVisible to set
	 */
	public void setMenuVisible(boolean menuVisible) {
		this.menuVisible = menuVisible;
	}

	/**
	 * @return the view
	 */
	public BaseView getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(BaseView view) {
		this.view = view;
	}

}
