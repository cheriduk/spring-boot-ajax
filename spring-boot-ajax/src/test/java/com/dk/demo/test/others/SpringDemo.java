package com.dk.demo.test.others;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @title: SpringDemo
 * @projectName spring-boot-ajax
 * @Description: TODO
 * @Auther: Cheri
 * @Date: 2019/4/25 14:35
 */
public class SpringDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
