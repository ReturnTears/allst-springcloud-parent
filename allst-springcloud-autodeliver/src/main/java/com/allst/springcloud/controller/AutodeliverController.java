package com.allst.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author June
 * @since 2021年04月
 */
@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // 调用远程服务 > 简历微服务接口 RestTemplate > JdbcTemplate
        // httpclient封装了好多进行远程调用
        Integer forObject = restTemplate.getForObject("http://localhost:8081/resume/openState/" + userId, Integer.class);
        System.out.println("forObject:" + forObject);
        return forObject;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 服务注册到Eureka之后的改造
     *
     * @param userId userId
     * @return 结果
     */
    @GetMapping("/checkState2/{userId}")
    public Integer findResumeOpenStateBy(@PathVariable Long userId) { // userId: 1545132
        // 从Eureka Server中获取我们关注的服务的实例信息以及接口信息
        List<ServiceInstance> instances = discoveryClient.getInstances("sc-service-resume");
        // 如果多个实例，选择一个，负载均衡的过程
        ServiceInstance serviceInstance = instances.get(0);
        // 元数据信息
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + host + ":" + port + "/resume/openState/" + userId;
        System.out.println("从Eureka server获取的服务实例：" + url);
        // 调用远程服务 > 简历微服务接口 RestTemplate > JdbcTemplate
        // httpclient封装了好多进行远程调用
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        System.out.println("forObject:" + forObject);
        return forObject;
    }

    /**
     * 使用Ribbon负载均衡
     *
     * @param userId userId
     * @return 结果
     */
    @GetMapping("/checkPort/{userId}")
    public Integer findResumeOpenStateByRibbon(@PathVariable Long userId) { // userId: 1545132
        String url = "http://sc-service-resume/resume/openPort/" + userId;
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        System.out.println("forObject:" + forObject);
        return forObject;
    }

    /**
     * 提供者模拟处理超时， 调用方法添加Hystrix控制
     * 注解HystrixCommand用于熔断控制
     *      commandProperties熔断的一些细节属性配置
     *          每一个属性都是一个HystrixProperty
     * @param userId userId
     * @return 结果
     */
    @HystrixCommand(
            // 线程池标识
            threadPoolKey = "findResumeOpenStateTimeOut",
            // 线程池属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"), // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
    )
    @GetMapping("/checkTimeOut/{userId}")
    public Integer findResumeOpenStateTimeOut(@PathVariable Long userId) { // userId: 1545132
        String url = "http://sc-service-resume/resume/openPort/" + userId;
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        System.out.println("timeout:" + forObject);
        return forObject;
    }

    /**
     * 服务降级
     *
     * @param userId userid
     * @return 结果
     */
    @HystrixCommand(
            // 线程池标识
            threadPoolKey = "findResumeOpenStateFallBack",
            // 线程池属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"), // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列
            },
            // 熔断相关属性配置
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // Hystrix高级配置 >>
                    // 统计时间窗口定义
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            },
            fallbackMethod = "myFallBack" // 回退方法
    )
    @GetMapping("/checkFallBack/{userId}")
    public Integer findResumeOpenStateFallBack(@PathVariable Long userId) { // userId: 1545132
        String url = "http://sc-service-resume/resume/openPort/" + userId;
        Integer forObject = restTemplate.getForObject(url, Integer.class);
        System.out.println("fallback:" + forObject);
        return forObject;
    }

    /**
     * 定义回退方法， 返回预设默认值， 注意： 该方法的形参和返回值与原始方法保持一致
     * @param userId userId
     * @return 结果
     */
    public Integer myFallBack(Long userId) {
        return  -1;
    }
}
