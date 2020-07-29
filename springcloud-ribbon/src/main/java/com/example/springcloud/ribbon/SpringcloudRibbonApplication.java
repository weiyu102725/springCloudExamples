package com.example.springcloud.ribbon;

import com.example.springcloud.ribbon.configuration.ExcludeFromComponentScan;
import com.example.springcloud.ribbon.configuration.RibbonClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.springcloud.ribbon",excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,value= ExcludeFromComponentScan.class)})
@RestController
public class SpringcloudRibbonApplication {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonApplication.class, args);
    }

    @GetMapping(value = {"/test"})
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICE-PROVIDER");
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost() , serviceInstance.getPort()));
        System.out.println(uri.toString());
        return uri.toString();
    }

}
