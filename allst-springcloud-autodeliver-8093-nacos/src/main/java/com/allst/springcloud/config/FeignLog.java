package com.allst.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author June
 * @since 2021年04月
 */
@Configuration
public class FeignLog {
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
