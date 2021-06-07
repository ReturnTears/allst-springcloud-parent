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
//@EnableEurekaClient // 用法1：开启Eureka Client（Eureka独有）
@EnableDiscoveryClient // 用法2：开启注册中客户端，（通用型注解， 比如注册到Eureka，Nacos）， 说明从SpringCLoud Edgware版本开始， 不添加注解也ok, 建议加上
public class ResumeApplication8082 {
    public static void main( String[] args ) {
        SpringApplication.run(ResumeApplication8082.class, args);
    }
}
