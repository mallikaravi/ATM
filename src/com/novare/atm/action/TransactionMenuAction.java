package com.novare.atm.action;

import com.novare.atm.controller.TransactionController;
import com.novare.atm.model.User;
import com.novare.atm.service.ITransactionService;
import com.novare.atm.service.impl.TransactionServiceImpl;
import com.novare.atm.util.MenuContext;
import com.novare.atm.view.TransactionView;

public class TransactionMenuAction extends BaseMenuAction {

	public TransactionMenuAction(MenuContext context, User currentUser) throws Exception {
		super(currentUser);
		TransactionView view = new TransactionView("Transaction Menu:");
		ITransactionService model = new TransactionServiceImpl();
		TransactionController controller = new TransactionController(model, view);
		controller.requestUserInput(context, currentUser);
	}
}
