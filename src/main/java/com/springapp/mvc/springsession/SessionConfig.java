//package com.springapp.mvc.springsession;
//
///**
// * Created by wangjie on 16-1-8.
// */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
//public class SessionConfig
//{
//    @Bean
//    public JedisConnectionFactory connectionFactory()
//    {
//        JedisConnectionFactory connection = new JedisConnectionFactory();
//        connection.setPort(6379);
//        connection.setHostName("localhost");
//        connection.setPassword("123456");
//        connection.setTimeout(30);
//        connection.setUsePool(true);
//        return connection;
//    }
//}
