package com.jiang.springcloud.controller;

import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZKController
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/22
 * @Version V1.0
 **/

@RestController
@Slf4j
public class OrderZKController {

    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/zk",payment, CommonResult.class);
    }
}
