package com.jiang.springcloud.controller;

import com.jiang.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Mr.Jiang
 * @date: 2020/10/13 15:00
 * @version: 1.0
 **/

@RestController
public class SendMessageController {

    @Resource
    private IMessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        String send = messageService.send();
        return send;
    }

}

