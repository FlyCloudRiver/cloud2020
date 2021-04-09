package com.jiang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConfigClientMain3355
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/5/28
 * @Version V1.0
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {

    public static void main(String[] args){
        SpringApplication.run(NacosConfigClientMain3377.class);
    }

}
