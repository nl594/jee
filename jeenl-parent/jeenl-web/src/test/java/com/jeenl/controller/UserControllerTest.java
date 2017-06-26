package com.jeenl.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeenl.dao.UserDao;
import com.jeenl.dao.impl.UserDaoImpl;
import com.jeenl.service.UserService;
import com.jeenl.service.impl.UserServiceImpl;

public class UserControllerTest {
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
//		ctx = new AnnotationConfigApplicationContext(UserDaoImpl.class);
//		UserDao userDao=ctx.getBean("userDaoImpl",UserDaoImpl.class);
//		userDao.login("nl", "niu");
//		ctx = new AnnotationConfigApplicationContext(UserServiceImpl.class);
//		UserService userService=ctx.getBean("userServiceImpl",UserServiceImpl.class);
//		userService.login("nl", "niu");
	}
	
}