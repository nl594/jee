package com.jeenl.dao;

import org.apache.ibatis.annotations.Param;

import com.jeenl.user.dto.User;

public interface UserDao {
	
	public User login(@Param("name") String name,@Param("password") String password);

	public User loadUser(int id);

	public void doDeleteUser(int id);
	
	public void doCreateUser(User inputs);
	
	public void doUpdateUser(User inputs);
	
	public User loadUserByOpenid(String openid);
}
