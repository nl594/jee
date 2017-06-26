package com.jeenl.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeenl.service.UserService;
import com.jeenl.user.dto.User;

@Controller
public class UserController {
	
	@Resource(name="userServiceImpl")
	private UserService userService;

	@RequestMapping("/userlogin")
	public ModelAndView userlogin(
			@RequestParam(value = "name", required = false, defaultValue = "NL") String name,
			@RequestParam(value = "password", required = false, defaultValue = "niulong") String password,
			Model model) {
		userService.login(name, password);
		ModelAndView view = new ModelAndView("loginSuccess","haha",name);
		return view;
	}
	
	@RequestMapping(value="/userload",method=RequestMethod.GET)
	public ModelAndView loadUser(@RequestParam(value = "userName", required = false, defaultValue = "niulong") String userName){
		ModelAndView view = new ModelAndView("xmlView",BindingResult.MODEL_KEY_PREFIX+"testttt",userName);
		return view;
	}
	
//	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
//	public User findUser(@PathVariable int id){
//		User user = userService.loadUser(id);
//		return user;
//	}
	
	@RequestMapping(value="/user/find",method=RequestMethod.GET)
	public User findUser(@RequestParam int id){
		User user = userService.loadUser(id);
		return user;
	}
	@RequestMapping(value="/user/delete",method=RequestMethod.DELETE)
	public User doDeleleUser(@RequestParam int id){
		userService.doDeleteUser(id);
		return null;
	}
	@RequestMapping(value="/user/create",method=RequestMethod.POST)
	public User doCreateUser(@ModelAttribute User user){
		userService.doCreateUser(user);
		return null;
	}
	@RequestMapping(value="/user/update",method=RequestMethod.PUT)
	public User doUpdateUser(@ModelAttribute User user){
		userService.doUpdateUser(user);
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}