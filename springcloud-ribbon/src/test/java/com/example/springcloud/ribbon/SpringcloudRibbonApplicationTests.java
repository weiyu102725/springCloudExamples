package com.example.springcloud.ribbon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.URI;

@SpringBootTest
class SpringcloudRibbonApplicationTests {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    void contextLoads() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICE-PROVIDER");
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost() , serviceInstance.getPort()));
        System.out.println(uri.toString());
    }

}
