package com.jeenl.service.impl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeenl.dao.UserDao;
import com.jeenl.dao.impl.UserDaoImpl;
import com.jeenl.service.UserService;

public class UserServiceImplTest{
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
//		ctx = new AnnotationConfigApplicationContext(UserServiceImpl.class);
//		UserService userService=ctx.getBean("userServiceImpl",UserServiceImpl.class);
//		userService.login("nl", "niu");
	}
}
