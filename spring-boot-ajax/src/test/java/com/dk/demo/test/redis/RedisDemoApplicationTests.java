package com.dk.demo.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Cheri
 * @title: RedisDemoApplicationTests
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2117:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.dk.*"})
public class RedisDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("redisKey","cluster test");
        System.out.println(opsForValue.get("redisKey"));
    }
}
