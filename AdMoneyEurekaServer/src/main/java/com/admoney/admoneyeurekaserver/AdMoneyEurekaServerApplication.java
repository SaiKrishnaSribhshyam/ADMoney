package com.admoney.admoneyeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdMoneyEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdMoneyEurekaServerApplication.class, args);
    }

}
