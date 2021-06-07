package com.allst.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author June
 * @since 2021年04月
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamProducerApplication9090 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication9090.class, args);
    }
}
