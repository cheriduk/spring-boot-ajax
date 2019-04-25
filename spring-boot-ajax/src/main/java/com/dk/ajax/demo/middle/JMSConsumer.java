package com.dk.ajax.demo.middle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Cheri
 * @title: JMSConsumer
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2123:35
 */
@Component
public class JMSConsumer {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String msg) {
        logger.info("接收到消息：{}",msg);
    }
}
