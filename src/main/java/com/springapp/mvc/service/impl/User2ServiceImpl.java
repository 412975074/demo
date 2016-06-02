package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.entity.UserEntity;
import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.service.User2Service;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjie on 16-1-29.
 */

@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    /**
     * 同一个class里，无事务的方法调用有事务的方法，都不会回滚。
     * 不同的class里，无事务的方法调用有事务的方法，有事务的方法会回滚，无事务里其他方法不会回滚。
     * 有事务方法调用无事务方法，不管怎样都会回滚。
     * @return
     */
    @Override
    public int update() {
        int effectCount = userDao.update(1, "wangjie2");
        userService.insert();
        return effectCount;
    }

    @Override
    public UserEntity load() {
        UserEntity entity = userDao.load(1);
        return entity;
    }
}
