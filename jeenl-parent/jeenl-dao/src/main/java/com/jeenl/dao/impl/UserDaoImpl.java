package com.jeenl.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.jeenl.dao.UserDao;
import com.jeenl.user.dto.User;
//@Component("UserDaoImpl")
public class UserDaoImpl implements UserDao{
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	public User login(String name, String password) {
		if(log.isDebugEnabled()){
			System.out.println("log:"+name+"==============="+password);
		}
		System.out.println(name+"==============="+password);
		return null;
	}

	@Override
	public User loadUser(int id) {
		User user = new User();
		user.setId(id);
		user.setUserName("牛龙");
		user.setBirthday(new Date());
		if(log.isDebugEnabled()){
			log.debug(user.getUserName()+"===============已获取");
		}
		System.out.println(user.getUserName()+"===============已获取");
		return user;
	}
	@Override
	public void doDeleteUser(int id) {
		User user = new User();
		user.setId(id);
		user.setUserName("利珍");
		user.setBirthday(new Date());
		System.out.println(user.getUserName()+"===============已删除");
	}
	
	@Override
	public void doCreateUser(User inputs){
		System.out.println(inputs.getUserName()+"===============已创建");
		inputs.setId(1);
		inputs.setBirthday(new Date());
	}
	
	@Override
	public void doUpdateUser(User inputs){
		System.out.println(inputs.getUserName()+"===============已更新");
		inputs.setId(10);
		inputs.setBirthday(new Date());
	}

	@Override
	public User loadUserByOpenid(String openid) {
		// TODO 自动生成的方法存根
		return null;
	}

}
