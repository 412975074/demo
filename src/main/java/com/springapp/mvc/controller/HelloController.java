package com.springapp.mvc.controller;

import com.springapp.mvc.annotation.AccessRequired;
import com.springapp.mvc.entity.UserEntity;
import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.exception.ResultResponse;
import com.springapp.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	HelloService helloService;

	@Autowired
	StringRedisTemplate redisTemplate;

	@RequestMapping(value="hello", method = RequestMethod.GET)
	@AccessRequired
	@ResponseBody
	public ResultResponse hello(HttpServletRequest request) {
		request.getSession().setAttribute("user1", "这里是spring-session-redis的测试");
		request.getSession().setAttribute("user2", "这里是spring-session-redis的测试2");
		return new ResultResponse(1,"good");
	}

	@RequestMapping(value="test", method = RequestMethod.GET)
	@ResponseBody
	public ResultResponse test(HttpServletRequest request) {
		UserEntity entity = new UserEntity();
		entity.setName("wang");
		entity.setId(99);
		helloService.say("hello", "world", entity);
//		helloService.redis();
		System.out.println(request.getSession().getAttribute("user1"));
		return new ResultResponse(1,"hello");
	}
}