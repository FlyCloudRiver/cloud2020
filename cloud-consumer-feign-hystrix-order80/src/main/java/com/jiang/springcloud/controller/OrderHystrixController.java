package com.jiang.springcloud.controller;

import com.jiang.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderHystrixController
 * @Description:
 * @Author: Mr.Jiang
 * @Date: 2020/4/4 17:31
 * @Version: 1.0
 **/


@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("**********result"+result);
        return result;
    }


    @GetMapping("/payment/hystrix/timeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("**********result"+result);
        return result;
    }

    // 服务降级  用来兜底的方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"    （我是兜底方法）系统忙碌或运行报错，请稍后再试,请检查自己,id:"+id+"\t"+"o(╥﹏╥)o";

    }
}
