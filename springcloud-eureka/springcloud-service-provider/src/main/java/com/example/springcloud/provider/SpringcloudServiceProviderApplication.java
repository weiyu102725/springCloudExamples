package com.example.springcloud.provider;

import com.example.springcloud.provider.bean.User;
import com.example.springcloud.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringcloudServiceProviderApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
    }

    @GetMapping({"/api/users/{username}"})
    @ResponseBody
    public User findUser(@PathVariable("username")String username) throws InterruptedException{
        User user=  userService.findUser(username);
        //User user = new User("nicky","http://smilenicky.blog.csdn.net");
        return user;
    }
}
