package com.dk.ajax.demo.middle.demo;

/**
 * @author Cheri
 * @title: MessageProducerServiceImpl
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/221:10
 */
import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Override
    public void sendMessage(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}
