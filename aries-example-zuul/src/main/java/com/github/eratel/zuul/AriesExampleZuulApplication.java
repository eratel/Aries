package com.github.eratel.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class AriesExampleZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesExampleZuulApplication.class, args);
    }


}

