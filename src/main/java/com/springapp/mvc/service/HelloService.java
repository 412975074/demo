package com.springapp.mvc.service;

import com.springapp.mvc.entity.UserEntity;
import com.springapp.mvc.exception.AppException;

/**
 * Created by wangjie on 16-1-4.
 */
public interface HelloService {

    public String say(String name, String value, UserEntity userEntity);

    public void redis();

    public void globalException();
}
