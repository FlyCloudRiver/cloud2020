package com.jiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
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
public class OrderController {

    private static final String PAYMENT_URL="http://consul-provider-payment";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

}
