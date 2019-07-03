package com.abhsy.eureka;

import com.abhsy.aries.constant.AriesConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AriesExampleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesExampleServerApplication.class, args);
    }

    @RequestMapping("test")
    public String test(@RequestHeader(AriesConstant.STRATEGYVERSION)String name){
        System.out.println(name);
        return name;
    }
}

