package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.entity.UserEntity;
import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.service.User2Service;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by wangjie on 16-1-29.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public int insert() {
        UserEntity entity = new UserEntity();
        entity.setName("test");
        int effectCount = userDao.insert(entity);
        throw new AppException(-200,"事务测试");
    }

    @Override
    public int update() {
        int effectCount = userDao.update(1, "wangjie2");
        return effectCount;
    }

    @Override
    public UserEntity load() {
        UserEntity entity = userDao.load(1);
        return entity;
    }
}
