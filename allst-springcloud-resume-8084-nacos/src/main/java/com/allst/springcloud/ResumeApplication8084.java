package com.allst.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan("com.allst.springcloud.pojo")
@EnableDiscoveryClient
public class ResumeApplication8084 {
    public static void main( String[] args ) {
        SpringApplication.run(ResumeApplication8084.class, args);
    }
}
