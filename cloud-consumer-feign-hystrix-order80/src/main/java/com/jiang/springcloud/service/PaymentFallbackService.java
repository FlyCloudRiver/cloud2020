package com.jiang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentFallbackService
 * @Description:
 * @Author: Mr.Jiang
 * @Date: 2020/5/9 14:50
 * @Version: 1.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------PaymentFallbackService___paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------PaymentFallbackService___paymentInfo_TimeOut";
    }
}
