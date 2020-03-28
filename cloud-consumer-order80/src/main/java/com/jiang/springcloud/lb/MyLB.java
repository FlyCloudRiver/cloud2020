package com.jiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/28
 * @Version V1.0
 **/

@Component
public class MyLB implements LoadBalancer{

    // AtomicInteger是一个提供原子操作的Integer类，通过线程安全的方式操作加减。
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            // 2147483647 它等于2^31-1，是32位操作系统中最大的符号型整型常量
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问，次数next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        // rest接口  第几次请求数 % 服务器集群总数量 = 实际调用服务位置下标
       int index = getAndIncrement() % serviceInstances.size();
       return serviceInstances.get(index);
    }
}
