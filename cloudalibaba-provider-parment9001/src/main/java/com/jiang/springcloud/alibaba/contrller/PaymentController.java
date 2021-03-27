package com.jiang.springcloud.alibaba.contrller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Description: TODO
 * @Author Administrator
 * @Date 2021/3/27
 * @Version V1.0
 **/

@RestController
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        return "nacos registry,sercerPort: " + serverPort+"\t id"+ id;

    }
}
