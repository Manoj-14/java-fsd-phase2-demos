package com.mvc.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.mvc.demo.models.User;

public class UserDataUtil {
	public static List<User> getUsers(){
		List<User> users =  new ArrayList<>();
		
		users.add(new User("Manoj", "M", "manoj@gmail.com", "Manoj"));
		users.add(new User("Mohan", "Prakash", "mohan@gmail.com", "mohan"));
		users.add(new User("Karthik", "Udupa", "udupa@gmail.com", "udupa"));
		
		return users;
	}
}
