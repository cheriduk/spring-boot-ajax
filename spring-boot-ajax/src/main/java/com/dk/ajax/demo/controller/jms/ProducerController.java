package com.dk.ajax.demo.controller.jms;

/**
 * @author Cheri
 * @title: ProducerController
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:35
 */
import com.dk.ajax.demo.middle.web.MsgService;
import com.dk.ajax.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class ProducerController {

    private final MsgService msgService;

    @Autowired
    public ProducerController(MsgService msgService) {
        this.msgService = msgService;
    }

    @RequestMapping("/index_jms")
    public ModelAndView index(){
        return new ModelAndView("index_jms");
    }

    @RequestMapping("/send")
    public String send(Message message){
        System.out.println("前台：" + message);
        msgService.addMessage(message);
        return "ok";
    }

}