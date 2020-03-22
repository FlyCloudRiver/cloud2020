package com.jiang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextBean
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/22
 * @Version V1.0
 **/

@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
