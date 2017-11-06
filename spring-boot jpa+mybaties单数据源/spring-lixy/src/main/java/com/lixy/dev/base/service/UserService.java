package com.lixy.dev.base.service;

import java.util.List;
import java.util.Map;

import com.lixy.dev.base.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Gets the list.
	 *
	 * @param map the map
	 * @return the list
	 */
	public List<User> getList(Map<String, Object> map);
	
	/**
	 * Gets the user by name.
	 *
	 * @param username the user name
	 * @return the user by name
	 */
	public User getUserByName(String username);


	public void saveUser(User user);


	public void insertUser(User user);
}
