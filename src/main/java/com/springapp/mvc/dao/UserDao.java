package com.springapp.mvc.dao;

import com.springapp.mvc.entity.UserEntity;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    public int insert(@Param("entity") UserEntity entity);
    
    public UserEntity load(@Param("id") long id);

    public int update(@Param("id") int id, @Param("name") String name);

}
