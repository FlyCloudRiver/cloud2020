package com.jiang.springcloud.service;

import com.jiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
}