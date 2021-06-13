package com.allst.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启Fegin
public class AutodeliverApplication8093 {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        SpringApplication.run(AutodeliverApplication8093.class, args);
    }

}
