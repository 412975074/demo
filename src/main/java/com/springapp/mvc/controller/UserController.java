package com.springapp.mvc.controller;

import com.springapp.mvc.annotation.AccessRequired;
import com.springapp.mvc.exception.ResultResponse;
import com.springapp.mvc.service.HelloService;
import com.springapp.mvc.service.User2Service;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	StringRedisTemplate redisTemplate;

	@RequestMapping(value="insert", method = RequestMethod.GET)
	@ResponseBody
	public ResultResponse insert(HttpServletRequest request) {

		userService.insert();

		return new ResultResponse(1,"good");
	}

	@RequestMapping(value="update", method = RequestMethod.GET)
	@ResponseBody
	public ResultResponse update(HttpServletRequest request) {

		userService.update();

		return new ResultResponse(1,"good");
	}

	@RequestMapping(value="load", method = RequestMethod.GET)
	@ResponseBody
	public ResultResponse load(HttpServletRequest request) {

		userService.load();

		return new ResultResponse(1,"good");
	}

}