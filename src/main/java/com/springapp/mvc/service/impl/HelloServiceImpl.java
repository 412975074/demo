package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.UserEntity;
import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by wangjie on 16-1-4.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String say(String name, String value, UserEntity userEntity) {
        System.out.println(name);
        return name;
    }

    @Override
    public void redis() {
		ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
//		valueOperations.set("count","0");
        valueOperations.increment("count", 1);
		System.out.println("count：" + valueOperations.get("count"));
    }

    @Override
    public void globalException() {
        throw new AppException(-500,"我错了");
    }
}
