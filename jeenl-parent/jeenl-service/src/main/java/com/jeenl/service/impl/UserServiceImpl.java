package com.jeenl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jeenl.dao.UserDao;
import com.jeenl.service.UserService;
import com.jeenl.user.dto.User;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User login(String name, String password) {
		return userDao.login(name, password);
	}
	@Override
	public User loadUser(int id) {
		return userDao.loadUser(id);
	}
	@Override
	public void doDeleteUser(int id) {
		userDao.doDeleteUser(id);
	}

	@Override
	public void doCreateUser(User inputs){
		userDao.doCreateUser(inputs);
	}
	
	@Override
	public void doUpdateUser(User inputs){
		userDao.doUpdateUser(inputs);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	@Override
	public void doSaveOrUpdateUser(User user) {
		User dbUser = userDao.loadUserByOpenid(user.getOpenid());
		if(null == dbUser){
			userDao.doCreateUser(user);;
		}else{
			dbUser.setBirthday(user.getBirthday());
			dbUser.setUserName(user.getUserName());
			userDao.doUpdateUser(user);
		}
	}

}
