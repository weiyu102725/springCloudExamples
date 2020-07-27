package com.example.springcloud.springcloudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@Controller
public class SpringcloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
    }

    @GetMapping({"/api/users"})
    @ResponseBody
    public List<String> userlist(){
        return Arrays.asList("mojombo","pjhyett","wycats","ezmobius");
    }
}
