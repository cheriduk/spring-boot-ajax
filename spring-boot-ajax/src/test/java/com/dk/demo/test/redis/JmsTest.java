package com.dk.demo.test.redis;

import com.dk.ajax.demo.middle.JMSProducer;
import com.dk.demo.test.BaseTest;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;

/**
 * @author Cheri
 * @title: JmsTest
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2123:37
 */
public class JmsTest extends BaseTest {
    @Autowired
    private JMSProducer jmsProducer;

    @Test
    public void testJms() {
        Destination destination = new ActiveMQQueue("springboot.queue.test");

        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(destination,"hello,world!" + i);
        }
    }
}
