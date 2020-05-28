package com.jiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConfigClientMain3355
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/5/28
 * @Version V1.0
 **/

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3355.class);
    }

}
