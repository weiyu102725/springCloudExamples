package com.example.springcloud.hystrix.controller;

import com.example.springcloud.hystrix.bean.User;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *      RestController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/08/01 16:59  修改内容:
 * </pre>
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/findUser/{username}")
    public User index(@PathVariable("username")String username){
        return restTemplate.getForObject("http://EUREKA-SERVICE-PROVIDER/api/users/"+username,User.class);
    }

}
