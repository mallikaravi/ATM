package com.novare.atm.controller;

import javax.security.sasl.AuthenticationException;

import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.TransactionView;

public class TransactionController extends BaseController {

	public TransactionController(ITransactionService model, TransactionView view) {
		super(model, view);
	}

	public ITransactionService getModel() {
		return (ITransactionService) super.getModel();
	}

	public TransactionView getView() {
		return (TransactionView) super.getView();
	}

	public void requestTransactionInput(MenuContext context, User currentUser) throws Exception {
		if (!getModel().isValidUser(currentUser)) {
			throw new AuthenticationException();
		}
	}

}
