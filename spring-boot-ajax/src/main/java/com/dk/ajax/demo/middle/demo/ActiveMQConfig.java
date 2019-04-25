package com.dk.ajax.demo.middle.demo;

/**
 * @author Cheri
 * @title: ActiveMQConfig
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/221:09
 */
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("study.msg.queue") ;
    }
}