
package com.novare.atm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.novare.atm.action.WelcomeMenuAction;
import com.novare.atm.model.User;

/**
 * @author malli
 *
 */
public class ATMApp {

	public static void main(String[] args) throws IOException {
		User currentUser = null;
		try {
			new WelcomeMenuAction(currentUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void extracted()
			throws JsonProcessingException, IOException, StreamReadException, DatabindException {
		ObjectMapper mapper = new ObjectMapper();
		List<User> user = List.of(new User(1, "Kumar", "ravi", "23456"), new User(1, "Kumar", "ravi", "23456"),
				new User(1, "Kumar", "ravi", "23456"));

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		Files.write(Paths.get("assets/users.json"), json.getBytes());

		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);

		List<User> asList = mapper.readValue(Paths.get("assets/users.json").toFile(), javaType);
		System.out.println(asList);
	}

}
