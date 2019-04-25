package com.dk.demo.test.activeMQ;

/**
 * @author Cheri
 * @title: TestActiveMQ
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/221:11
 */
import javax.annotation.Resource;

import com.dk.ajax.demo.middle.demo.IMessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = com.dk.ajax.demo.AjaxApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
    @Resource
    private IMessageProducerService messageProducer;
    @Test
    public void testSend() throws Exception {
        for (int x = 0; x < 10; x++) {
            this.messageProducer.sendMessage("study - " + x);
        }
    }
}