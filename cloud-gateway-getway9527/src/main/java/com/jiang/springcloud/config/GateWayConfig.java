package com.jiang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description: 相对于 配置文件 用硬编码模式  代码注入方式
 * @Author Administrator
 * @Date 2020/5/26
 * @Version V1.0
 **/

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        // 访问 http://localhost:9527/guonei  会转发到 http://news.baidu.com/guonei
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
