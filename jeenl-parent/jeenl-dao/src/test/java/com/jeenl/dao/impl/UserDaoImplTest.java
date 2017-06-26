package com.jeenl.dao.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jeenl.dao.UserDao;
import com.jeenl.user.dto.User;

public class UserDaoImplTest{
	
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		UserDao userDao=ctx.getBean("userDao",UserDao.class);
//		System.out.println(userDao.login("nl", "niu"));
		
		User user = new User();
		user.setBirthday(new Date());
		user.setOpenid("aaaaaaa");
		user.setUserName("lz");
		user.setPassword("guo");
		userDao.doCreateUser(user);
	}

}
