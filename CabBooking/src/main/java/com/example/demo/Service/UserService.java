package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Model.User;



public class UserService {
	private static Map<Integer, User>  users = new HashMap<>();
	private static int index = 2;
	static {
		User user1 = new User(1,"Abhishek",23,"M");
		User user2 = new User(2,"Rahul",25,"M");
		User user3 = new User(2,"Nandini",25,"F");
		users.put(1, user1);
		users.put(2, user2);
		users.put(3, user3);
	}
	
	public static List<User> getAllUsers(){
		return new ArrayList<>(users.values());
	}
	
	public static User addUser(User user) {
		index +=1 ;
		user.setId(index);
		users.put(index, user);
		return user;
	}
	
	
}
