package com.abhsy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
public class AriesExampleEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesExampleEurekaApplication.class, args);
    }


}

