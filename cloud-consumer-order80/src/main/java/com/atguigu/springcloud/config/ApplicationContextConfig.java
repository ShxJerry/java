package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    /*@LoadBalanced这个注解赋予RestTemplate负载均衡的能力*/
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//把 RestTemplate 注入到spring容器中