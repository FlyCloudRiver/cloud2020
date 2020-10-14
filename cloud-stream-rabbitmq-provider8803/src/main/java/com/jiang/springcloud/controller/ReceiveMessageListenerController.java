package com.jiang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description: 消息接收
 * @author: Mr.Jiang
 * @date: 2020/10/13 15:06
 * @version: 1.0
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("我是消费者2号，-----》接受到的消息是："+message.getPayload()+"\t"+serverPort);
    }

}

