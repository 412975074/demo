package com.springapp.mvc.test;

import redis.clients.jedis.Jedis;

/**
 * Created by wangjie on 15-12-28.
 */
public class RedisClient {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");//使用redis默认端口6379
//        jedis.select(1);
        jedis.auth("123456");

        System.out.println(jedis.keys("*"));

//        jedis.set("foo", "0");
        jedis.incr("foo");

//        System.out.println(jedis.get("spring:session:sessions:b738c4ca-4054-43cc-87d0-5d8129d54dc7"));

//        jedis.append("foo", " hello world!");
//        System.out.println(jedis.get("foo"));

//        jedis.setex("foo", 3, "expire");
//        System.out.println(jedis.get("foo"));


        System.out.println(jedis.get("foo"));
    }
}
