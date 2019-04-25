package com.dk.ajax.demo.middle.web.impl;

/**
 * @author Cheri
 * @title: ReceiveServiceImpl
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:33
 */

import com.dk.ajax.demo.middle.web.ReceiveService;
import com.dk.ajax.demo.model.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class ReceiveServiceImpl implements ReceiveService {

    @JmsListener(destination = "my-msg")
    @Override
    public void receiveMessage(Message message) throws JMSException {
        System.out.println("收到：" + message);
    }
}
