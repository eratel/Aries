package com.github.eratel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AriesExampleEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesExampleEurekaApplication.class, args);
    }


}

