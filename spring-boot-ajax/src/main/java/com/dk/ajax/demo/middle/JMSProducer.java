package com.dk.ajax.demo.middle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author Cheri
 * @title: JMSProducer
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2123:35
 */
@Component
public class JMSProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String message) {
        this.jmsTemplate.convertAndSend(destination,message);
    }
}