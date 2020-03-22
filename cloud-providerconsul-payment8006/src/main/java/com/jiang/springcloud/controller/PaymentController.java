package com.jiang.springcloud.controller;

import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import com.jiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/22
 * @Version V1.0
 **/

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentZk(){
        return "springcloud with zookeeper" + serverPort +"\t" + UUID.randomUUID().toString();
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverport:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverport:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

}
