package com.jiang.springcloud.service.impl;

import com.jiang.springcloud.entities.Payment;
import com.jiang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * @MethodName: paymentInfo_OK
     * @Description: 能够正常访问的方法
     * @Param: [id]
     * @Return: java.lang.String
     * @Author: jiang
     * @Date: 2020/4/4
    **/
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"    paymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }


    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"    paymentInfo_TimeOut,id:"+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时（秒）"+ timeNumber;
    }
}