package com.dk.ajax.demo.middle.demo;

/**
 * @author Cheri
 * @title: MessageConsumerService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/221:08
 */
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
    @JmsListener(destination="study.msg.queue")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.err.println("【*** 接收消息 ***】" + text);
    }
}