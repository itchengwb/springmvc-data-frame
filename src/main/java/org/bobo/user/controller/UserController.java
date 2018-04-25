package org.bobo.user.controller;

import org.bobo.user.po.User;
import org.bobo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sys")
public class UserController {
	//logger
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	//兼管Post Get请求方法
	@RequestMapping(value="/user/getAllUser",method={RequestMethod.GET,RequestMethod.POST})
	public String getAllUser(ModelMap model) {
		LOGGER.info("=====进入方法====");

		model.addAttribute("message", "Hello world!");

		//调用Service层方法
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);

		LOGGER.info("=====退出方法====");
		//跳转到hello页面
		return "userList";
	}

	//兼管Post Get请求方法
	@RequestMapping(value="/user/getUserByid",method={RequestMethod.GET,RequestMethod.POST})
	public String getUserByid(@RequestParam("id") Integer id,ModelMap model) {
		LOGGER.info("=====getUserByid进入方法"+id+"====");


		model.addAttribute("message", "Hello world!");

		//调用Service层方法
		List<User> userList = userService.getUserByid(id);
		model.addAttribute("userList", userList);

		LOGGER.info("=====getUserByid退出方法====");
		//跳转到hello页面
		return "userList";
	}
}