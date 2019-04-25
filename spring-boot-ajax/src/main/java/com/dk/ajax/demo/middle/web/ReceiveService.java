package com.dk.ajax.demo.middle.web;

/**
 * @author Cheri
 * @title: ReceiveService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:32
 */
import com.dk.ajax.demo.model.Message;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public interface ReceiveService {

    void receiveMessage(Message message) throws JMSException;
}
