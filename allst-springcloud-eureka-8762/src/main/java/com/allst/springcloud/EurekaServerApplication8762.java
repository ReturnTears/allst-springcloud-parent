package com.allst.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer // 声明为一个eureka服务
public class EurekaServerApplication8762 {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaServerApplication8762.class, args);
    }
}
