package com.jiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName controller
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/22
 * @Version V1.0
 **/

@RestController
@Slf4j
@RequestMapping("/consumer")
public class controller {

    private static final String PAYMENT_URL="http://consul-provider-payment";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
