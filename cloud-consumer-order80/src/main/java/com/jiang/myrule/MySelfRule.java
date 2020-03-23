package com.jiang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/23
 * @Version V1.0
 **/

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RandomRule();
    }

    // 负载均衡算法（轮询算法）：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务位置下标，每次服务重启后rest接口计数从 1开始
    // 例：总计数：2台
    // List = 2 instance
    // 1 % 2 = 1 -》 index = 1   list.get(index);
    // 2 % 2 = 0 -》 index = 0   list.get(index);
    // 1 % 2 = 1 -》 index = 1   list.get(index); 以此类推

}
