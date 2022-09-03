package com.novare.atm.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.novare.atm.model.User;

public class ServiceUtil {

	public static List<User> loadUsers() {
		List<User> users = new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
			users = mapper.readValue(Paths.get("assets/users.json").toFile(), javaType);
			return users;
		} catch (Exception e) {
			return users;
		}
	}

	public static void saveUsers(List<User> users) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
		Files.write(Paths.get("assets/users.json"), json.getBytes());
	}

}
