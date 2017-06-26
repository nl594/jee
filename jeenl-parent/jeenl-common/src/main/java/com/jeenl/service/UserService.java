package com.jeenl.service;

import com.jeenl.user.dto.User;

public interface UserService {
	public User login(String name,String password);

	public User loadUser(int id);

	public void doDeleteUser(int id);

	public void doCreateUser(User inputs);
	
	public void doUpdateUser(User inputs);

	public void doSaveOrUpdateUser(User user);
}
