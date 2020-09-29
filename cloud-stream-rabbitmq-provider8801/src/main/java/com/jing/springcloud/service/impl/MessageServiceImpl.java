package com.jing.springcloud.service.impl;

import com.jing.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;
/**
 * @ClassName MessageServiceImpl
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/9/29
 * @Version V1.0
 **/
@EnableBinding(Source.class)  //定义消息推送通道
public class MessageServiceImpl implements IMessageService {

    private MessageChannel output;  //消息发送通道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:"+serial);
        return serial;
    }
}

