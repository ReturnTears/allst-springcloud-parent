package com.allst.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解FeignClient表明当前类是一个Feign客户端，value指定该客户端要请求的服务名称（登记到注册中心上的服务提供者的服务名称）
 *
 * @author June
 * @since 2021年04月
 */
@FeignClient("sc-service-resume")
@RequestMapping("/resume")
public interface ResumeServiceFeignClient {

    @GetMapping("/openState/{userId}")
    public Integer findResumeState(@PathVariable("userId") Long userId);
}
