package com.dk.ajax.demo.middle.web.impl;

/**
 * @author Cheri
 * @title: MsgServiceImpl
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:32
 */
import com.dk.ajax.demo.middle.web.MsgService;
import com.dk.ajax.demo.model.Message;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class MsgServiceImpl implements MsgService {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MsgServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public void addMessage(Message message) {
        Destination destination = new ActiveMQQueue("my-msg");
        jmsTemplate.convertAndSend(destination, message);
    }
}
