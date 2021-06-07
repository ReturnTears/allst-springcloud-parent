package com.allst.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 注解EnableHystrixDashboard: 开启hystrix dashboard
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixDashboard9000 {
    public static void main( String[] args ) {
        SpringApplication.run(HystrixDashboard9000.class, args);
    }
}
