
package com.novare.atm;

import java.io.IOException;

import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;
import com.novare.atm.util.MenuContext;

/**
 * @author malli
 *
 */
public class ATMApp {

	public static void main(String[] args) throws IOException {
		User currentUser = null;
		try {
			new WelcomeMenuAction(MenuContext.WELCOME, currentUser);
		} catch (Exception e) {
			System.out.println("Error, Not able to run the application !\n Due to the " + e.getMessage());
		}
	}

}
