package com.dk.ajax.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Cheri
 * @title: AjaxApplication
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2018:49
 */
@SpringBootApplication
@MapperScan("com.dk.ajax.demo.dao.mapper")
@EnableJms //启动消息队列
public class AjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjaxApplication.class,args);
    }
}
