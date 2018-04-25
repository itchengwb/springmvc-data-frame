package org.bobo.score.controller;

import com.noriental.utils.json.JsonUtil;
import org.bobo.common.JsonMapper;
import org.bobo.score.po.Score;
import org.bobo.score.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreController {
	//logger
	private final Logger LOGGER = LoggerFactory.getLogger(ScoreController.class);

	@Autowired
	ScoreService scoreService;

	//兼管Post Get请求方法
	@RequestMapping(value="/score",method={RequestMethod.GET,RequestMethod.POST})
	public String getScore(ModelMap model) {
		LOGGER.info("=====getScore进入方法====");

		model.addAttribute("message", "Hello world!");

		//调用Service层方法
		List<Score> scoreList = scoreService.getAllScore();
		model.addAttribute("scoreList", scoreList);

		LOGGER.info("=====getScore退出方法====");
		//跳转到hello页面
		return "scoreList";
	}

	//兼管Post Get请求方法
	@RequestMapping(value="/getScoreByid",method={RequestMethod.GET,RequestMethod.POST})
	public String getScoreByid(@RequestParam("id") Integer id,ModelMap model) {
		LOGGER.info("=====getScoreByid进入方法"+id+"====");


		model.addAttribute("message", "Hello world!");

		//调用Service层方法
		List<Score> scoreList = scoreService.getScoreByid(1);
		model.addAttribute("scoreList", scoreList);

		LOGGER.info("=====getScoreByid退出方法====");
		//跳转到hello页面
		return "scoreList";
	}

	//兼管Post Get请求方法
	@RequestMapping(value="/jsonp",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object jsonp(@RequestParam("callback") String callback) {
		LOGGER.info("=====jsonp:"+callback+"====");

		Score score = new Score();
		score.setId(1);
		score.setScore(36);
		score.setUserId(2323);

		// String str = (cb + "(" + JsonUtil.obj2Json(commonResponse) + ")");
		String str = (callback + "(" + JsonUtil.obj2Json(score) + ")");

		//跳转到hello页面
		return str;
	}
}