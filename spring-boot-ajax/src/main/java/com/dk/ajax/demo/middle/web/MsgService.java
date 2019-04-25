package com.dk.ajax.demo.middle.web;

/**
 * @author Cheri
 * @title: MsgService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:30
 */
import com.dk.ajax.demo.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface MsgService {
    void addMessage(Message message);
}
