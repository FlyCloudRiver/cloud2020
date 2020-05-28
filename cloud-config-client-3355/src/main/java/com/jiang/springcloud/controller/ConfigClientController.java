package com.jiang.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/5/28
 * @Version V1.0
 **/
@RestController
@RefreshScope   //刷新配置
public class ConfigClientController {

    // 从配置文件读取
    @Value("${config.info}")
    private  String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
