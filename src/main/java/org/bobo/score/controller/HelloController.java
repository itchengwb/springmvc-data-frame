package org.bobo.score.controller;

import org.bobo.score.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	//logger
	private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	HelloService helloService;

	//兼管Post Get请求方法
	@RequestMapping(value = "hello",method={RequestMethod.GET,RequestMethod.POST})
	public String printWelcome(ModelMap model) {
		LOGGER.info("=====进入方法====");

		model.addAttribute("message", "Hello world!");
		//调用Service层方法
		helloService.sayHello();

		LOGGER.info("=====退出方法====");
		//跳转到hello页面
		return "hello";
	}
}