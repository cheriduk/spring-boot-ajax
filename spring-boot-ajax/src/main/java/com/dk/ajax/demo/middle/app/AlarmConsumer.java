package com.dk.ajax.demo.middle.app;

/**
 * @author Cheri
 * @title: AlarmConsumer
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/221:27
 */
import org.apache.commons.lang.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 围栏报警Consumer
 * @author ko
 *
 */
@Component
public class AlarmConsumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    // @SendTo("out.queue") 为了实现双向队列
    public void receiveQueue(String text) {
        if(StringUtils.isNotBlank(text)){
            System.out.println("AlarmConsumer收到的报文为:"+text);
            System.out.println("把报警信息["+text+"]发送邮件给xxx");
            System.out.println("把报警信息["+text+"]发送短信给xxx");
            System.out.println("");
        }
    }
}