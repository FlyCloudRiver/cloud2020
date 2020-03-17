package com.jiang.springcloud.service;

import org.apache.ibatis.annotations.Param;
import com.jiang.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}