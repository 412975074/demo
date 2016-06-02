package com.springapp.mvc.service;

import com.springapp.mvc.entity.UserEntity;

/**
 * Created by wangjie on 16-1-29.
 */
public interface UserService {

    public int insert();

    public int update();

    public UserEntity load();
}
