package com.jiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    // 获取服务数量
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
